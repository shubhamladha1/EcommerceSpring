package com.example.ecommercespring.gateway;

import com.example.ecommercespring.dto.ProductDTO;

import java.util.List;

public interface IProductsGateway {

    List<ProductDTO> getAllProducts();

}
