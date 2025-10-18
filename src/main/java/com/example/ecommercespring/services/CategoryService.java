package com.example.ecommercespring.services;
import com.example.ecommercespring.dto.CategoryDTO;
import com.example.ecommercespring.entity.Category;
import com.example.ecommercespring.mappers.CategoryMapper;
import com.example.ecommercespring.repository.CategoryRepository;
import org.springframework.stereotype.Service;

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

}
