package com.example.ecommercespring.services;
import com.example.ecommercespring.dto.ProductDTO;
import com.example.ecommercespring.dto.ProductWithCategoryDTO;

public interface IProductService {

    ProductDTO getProductById(Long id);
    ProductDTO createProduct(ProductDTO productDTO) throws Exception;
    ProductWithCategoryDTO getProductWithCategory(Long id) throws  Exception;
}
