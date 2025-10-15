package com.example.ecommercespring.controllers;
import com.example.ecommercespring.dto.ProductDTO;
import com.example.ecommercespring.services.IProductsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Products")
public class ProductsController {

    //@Autowired will also help in resolving DI but it does not allow final keyword to be added and Autowired is not recommended
    private final IProductsService productsService;

    ProductsController(IProductsService _productsService) {
         this.productsService = _productsService;
    }

    @GetMapping
    public List<ProductDTO> getAllProducts(){
        return this.productsService.getAllProducts();
    }

}
