package com.example.ecommercespring.services;
import com.example.ecommercespring.dto.ProductDTO;
import com.example.ecommercespring.entity.Category;

public interface IProductService {

    ProductDTO getProductById(Long id) throws Exception;

    ProductDTO createProduct(ProductDTO productDTO) throws Exception;
}
