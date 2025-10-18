package com.example.ecommercespring.services;
import com.example.ecommercespring.dto.CategoryDTO;
import com.example.ecommercespring.entity.Category;
import com.example.ecommercespring.mappers.CategoryMapper;
import com.example.ecommercespring.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements ICategoryService{

    private final CategoryRepository repo;

    public CategoryService(CategoryRepository _repo){
        this.repo = _repo;
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
    public CategoryDTO getCategoriesByName(String name) throws Exception {
        Category category = repo.findByName(name)
                .orElseThrow(() -> new Exception("Category not found with name: " + name));
        return CategoryMapper.toDto(category);
    }
}
