package com.example.ecommercespring.services;
import com.example.ecommercespring.dto.ProductDTO;
import com.example.ecommercespring.entity.Product;
import com.example.ecommercespring.mappers.ProductMapper;
import com.example.ecommercespring.repository.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class ProductService implements IProductService {

    private final ProductRepository repo;
    public ProductService(ProductRepository _repo){
        this.repo = _repo;
    }

    @Override
    public ProductDTO getProductById(Long id) throws Exception{
        return this.repo.findById(id)
                .map(ProductMapper::toDto)
                .orElseThrow(() -> new Exception("Product not found"));
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO){
        Product saved =  repo.save(ProductMapper.toEntity(productDTO));
        return ProductMapper.toDto(saved);
    }

}
