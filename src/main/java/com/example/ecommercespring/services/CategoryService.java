package com.example.ecommercespring.services;
import com.example.ecommercespring.dto.AllProductsOfCategoryDTO;
import com.example.ecommercespring.dto.CategoryDTO;
import com.example.ecommercespring.dto.ProductDTO;
import com.example.ecommercespring.entity.Category;
import com.example.ecommercespring.mappers.CategoryMapper;
import com.example.ecommercespring.mappers.ProductMapper;
import com.example.ecommercespring.repository.CategoryRepository;
import com.example.ecommercespring.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService implements ICategoryService{

    private final CategoryRepository repo;
    private final ProductRepository productRepo;

    public CategoryService(CategoryRepository _repo, ProductRepository _productRepo){
        this.repo = _repo;
        this.productRepo = _productRepo;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category saved =  repo.save(CategoryMapper.toEntity(categoryDTO));
        return CategoryMapper.toDto(saved);
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws Exception {
        List<CategoryDTO> dtos = new ArrayList<>();
        List<Category> categories = repo.findAll();
        for (Category category : categories) {
            dtos.add(CategoryMapper.toDto(category));
        }
        return dtos;
    }

    @Override
    public CategoryDTO getCategoryByName(String name) throws Exception {
        Category category = repo.findByName(name)
                .orElseThrow(() -> new Exception("Category not found with name: " + name));
        return CategoryMapper.toDto(category);
    }

    @Override
    public AllProductsOfCategoryDTO getAllProductsOfCategory(Long id) {
        Category category = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        List<ProductDTO> productDTOs = category.getProducts()
                .stream()
                .map(product -> ProductMapper.toDto(product))
                .collect(Collectors.toList());

        return AllProductsOfCategoryDTO.builder()
                .categoryId(category.getId())
                .name(category.getName())
                .products(productDTOs)
                .build();
    }
}
