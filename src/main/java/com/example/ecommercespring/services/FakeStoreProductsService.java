package com.example.ecommercespring.services;

import com.example.ecommercespring.dto.ProductDTO;
import com.example.ecommercespring.gateway.IProductsGateway;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FakeStoreProductsService implements IProductsService {

    private final IProductsGateway productsGateway;

    FakeStoreProductsService(IProductsGateway productsGateway) {
        this.productsGateway = productsGateway;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return this.productsGateway.getAllProducts();
    }
}
