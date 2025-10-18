package com.example.ecommercespring.services;

import com.example.ecommercespring.dto.ProductDTO;

import java.util.List;

public interface IProductsService {

    List<ProductDTO> getAllProducts();
}
