package com.api.service;

import com.api.core.excepitonhandling.ServiceBusinessException;
import com.api.model.request.AddProductReq;
import com.api.model.request.UpdateProductReq;
import com.api.model.response.APIResponse;
import com.api.model.dto.ProductDTO;
import java.io.IOException;
import java.util.List;

public interface ProductService {
    APIResponse<List<ProductDTO>> getAllProducts();
    APIResponse<ProductDTO> getProductById(Integer id) throws ServiceBusinessException;
    APIResponse updateProduct(UpdateProductReq req) throws ServiceBusinessException, IOException;
    APIResponse deleteProduct(Integer id) throws ServiceBusinessException;
    APIResponse addProduct(AddProductReq req) throws Exception;
}
