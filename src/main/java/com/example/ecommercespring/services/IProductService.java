package com.example.ecommercespring.services;
import com.example.ecommercespring.dto.ProductDTO;

public interface IProductService {

    ProductDTO getProductById(Long id) throws Exception;

    ProductDTO createProduct(ProductDTO productDTO);
}
