package com.example.ecommercespring.services;
import com.example.ecommercespring.dto.AllProductsOfCategoryDTO;
import com.example.ecommercespring.dto.CategoryDTO;
import java.util.List;

public interface ICategoryService {

    CategoryDTO createCategory(CategoryDTO categoryDTO);
    List<CategoryDTO> getAllCategories() throws Exception;
    CategoryDTO getCategoryByName(String name) throws Exception;
    AllProductsOfCategoryDTO getAllProductsOfCategory(Long id);
}
