package com.example.ecommercespring.controllers;
import com.example.ecommercespring.dto.ProductDTO;
import com.example.ecommercespring.services.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/products")
public class ProductsController {

    //@Autowired will also help in resolving DI but it does not allow final keyword to be added and Autowired is not recommended
    private final IProductService productService;

    ProductsController(IProductService _productService) {
         this.productService = _productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable long id) throws Exception{
        return ResponseEntity.ok(this.productService.getProductById(id));
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
        return ResponseEntity.ok(this.productService.createProduct(productDTO));
    }

}
