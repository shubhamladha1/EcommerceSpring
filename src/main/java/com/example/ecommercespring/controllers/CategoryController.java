package com.example.ecommercespring.controllers;
import com.example.ecommercespring.dto.AllProductsOfCategoryDTO;
import com.example.ecommercespring.dto.CategoryDTO;
import com.example.ecommercespring.services.ICategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/category")
public class CategoryController {

    private final ICategoryService categoryService;

    CategoryController(ICategoryService _categoryService) {
        this.categoryService = _categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories() throws Exception{

        List<CategoryDTO> result = this.categoryService.getAllCategories();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/name")
    public ResponseEntity<CategoryDTO> getCategoryByName(@RequestParam(required = false) String name) throws Exception{
        return ResponseEntity.ok(this.categoryService.getCategoryByName(name));
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO ){
        return ResponseEntity.ok(this.categoryService.createCategory(categoryDTO));
    }

    @GetMapping("{id}/products")
    public ResponseEntity<AllProductsOfCategoryDTO> getAllProductsOfCategory(@PathVariable long id){
        return ResponseEntity.ok(this.categoryService.getAllProductsOfCategory(id));
    }
}
