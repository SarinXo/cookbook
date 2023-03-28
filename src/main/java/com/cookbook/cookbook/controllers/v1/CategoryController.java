package com.cookbook.cookbook.controllers.v1;

import com.cookbook.cookbook.models.CategoryIdAndNameDto;
import com.cookbook.cookbook.repositories.CategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("internal/api")
public class CategoryController {

    final private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository){this.categoryRepository = categoryRepository;}

    @GetMapping("/v1/categories")
    public List<CategoryIdAndNameDto> getAllCategories(){
        return categoryRepository.findAllCategories();
    }
}
