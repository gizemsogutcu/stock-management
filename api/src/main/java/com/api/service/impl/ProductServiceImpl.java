package com.api.service.impl;

import com.api.core.excepitonhandling.ServiceBusinessException;
import com.api.entity.Product;
import com.api.model.dto.ProductDTO;
import com.api.model.request.AddProductReq;
import com.api.model.request.UpdateProductReq;
import com.api.model.response.APIResponse;
import com.api.repository.ProductJPARepository;
import com.api.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ModelMapper modelMapper;
    private ProductJPARepository productJPARepository;


    @Autowired
    public ProductServiceImpl(ModelMapper modelMapper, ProductJPARepository productJPARepository) {
        this.modelMapper = modelMapper;
        this.productJPARepository = productJPARepository;
    }

    public APIResponse<List<ProductDTO>> getAllProducts() {
        List<Product> productList = productJPARepository.findByOrderById();

        List<ProductDTO> productDTOList = new ArrayList<>();

        productList.stream().forEach(s -> productDTOList.add(modelMapper.map(s, ProductDTO.class)));

        APIResponse apiResponse = new APIResponse();
        apiResponse.setBody(productDTOList);

        return apiResponse;
    }

    public APIResponse<ProductDTO> getProductById(Integer id) throws ServiceBusinessException {
        if(id == null)
            throw new ServiceBusinessException("Ürün id null olamaz!");

        Product product = productJPARepository.findById(id);

        if(product == null) {
            throw new ServiceBusinessException("Ürün bulunamadı!");
        }

        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);

        APIResponse apiResponse = new APIResponse();
        apiResponse.setBody(productDTO);

        return apiResponse;
    }

    public APIResponse updateProduct(UpdateProductReq req) throws ServiceBusinessException, IOException {
        Product product = productJPARepository.findById(req.getId());

        if(product == null) {
            throw new ServiceBusinessException("Güncellemek istediğiniz ürün bulunamadı!");
        }

        if(product.getPiece() == req.getPiece() && product.getPrice().equals(req.getPrice()))
            throw new ServiceBusinessException("Aynı bilgilerle güncelleme yapılamaz!");

        modelMapper.map(req, product);
        productJPARepository.save(product);

        return new APIResponse();
    }

    @Transactional
    public APIResponse deleteProduct(Integer id) throws ServiceBusinessException {
        if(id == null)
            throw new ServiceBusinessException("Ürün id null olamaz!");

        Product product = productJPARepository.findById(id);

        if(product == null) {
            throw new ServiceBusinessException("Silmek istediğiniz ürün bulunamadı!");
        }

        productJPARepository.deleteById(id);

        return new APIResponse();
    }

    public APIResponse addProduct(AddProductReq req) throws ServiceBusinessException, Exception {
        Product product = productJPARepository.findByName(req.getName().toLowerCase());

        if(product != null) {
            throw new ServiceBusinessException(String.format("%s isimli ürün daha önce eklenmiştir!", req.getName()));
        }

        product = modelMapper.map(req, Product.class);
        product = productJPARepository.save(product);

        if(product.getId() == null)
            throw new Exception("Ürün eklenirken hata oluştu!");

        return new APIResponse();
    }

}
