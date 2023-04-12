package com.cookbook.cookbook.controllers.v1;

import com.cookbook.cookbook.models.categories.CategoryIdAndNameDto;
import com.cookbook.cookbook.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("internal")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){this.categoryService = categoryService;}

    @GetMapping("/api/v1/categories")
    public List<CategoryIdAndNameDto> getAllCategories(){
        return categoryService.getAllCategories();
    }
}
