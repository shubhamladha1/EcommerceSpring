package com.example.ecommercespring.services;
import com.example.ecommercespring.dto.ProductDTO;
import com.example.ecommercespring.dto.ProductWithCategoryDTO;
import com.example.ecommercespring.entity.Category;
import com.example.ecommercespring.entity.Product;
import com.example.ecommercespring.exception.ProductNotFoundException;
import com.example.ecommercespring.mappers.ProductMapper;
import com.example.ecommercespring.repository.CategoryRepository;
import com.example.ecommercespring.repository.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class ProductService implements IProductService {

    private final ProductRepository repo;
    private final CategoryRepository categoryRepo;

    public ProductService(ProductRepository _repo, CategoryRepository _categoryRepo){
        this.repo = _repo;
        this.categoryRepo = _categoryRepo;
    }

    @Override
    public ProductDTO getProductById(Long id) {
        return repo.findById(id)
                .map(ProductMapper::toDto)
                .orElseThrow(() -> {
                    throw new ProductNotFoundException("Product with ID " + id + " not found");
                });
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) throws Exception {
        Category category = categoryRepo.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new Exception("Not valid catageory"));

        Product saved = repo.save(ProductMapper.toEntity(productDTO,category));
        return ProductMapper.toDto(saved);
    }

    @Override
    public ProductWithCategoryDTO getProductWithCategory(Long id) throws Exception {

        Product product = repo.findById(id)
                .orElseThrow(() -> new Exception("Product not found"));
        return ProductMapper.toProductWithCategoryDTO(product);
    }

}