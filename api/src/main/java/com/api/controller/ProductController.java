package com.api.controller;

import com.api.core.excepitonhandling.ServiceBusinessException;
import com.api.model.dto.ProductDTO;
import com.api.model.request.AddProductReq;
import com.api.model.request.UpdateProductReq;
import com.api.model.response.APIResponse;
import com.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = { "http://localhost:8081" })
@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping(path = "/all")
    public APIResponse<List<ProductDTO>> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping(path = "/{id}")
    public APIResponse<ProductDTO> getProductById(@PathVariable Integer id) throws ServiceBusinessException {
        return productService.getProductById(id);
    }

    @PostMapping("/update")
    public APIResponse updateProduct(@Validated @RequestBody UpdateProductReq req) throws ServiceBusinessException, IOException {
        return productService.updateProduct(req);
    }

    @DeleteMapping("/delete/{id}")
    public APIResponse deleteProduct(@PathVariable Integer id) throws ServiceBusinessException {
        return productService.deleteProduct(id);
    }

    @PostMapping("/add")
    public APIResponse addProduct(@Validated @RequestBody AddProductReq req) throws Exception {
        return productService.addProduct(req);
    }
}
