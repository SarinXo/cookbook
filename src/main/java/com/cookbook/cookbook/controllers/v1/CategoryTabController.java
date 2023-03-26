package com.cookbook.cookbook.controllers.v1;

import com.cookbook.cookbook.repositories.CategoryIdAndName;
import com.cookbook.cookbook.repositories.CategoryRepo;
import com.cookbook.cookbook.schemas.cookbook.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("internal/api/v1")
public class CategoryTabController {

    final private CategoryRepo categoryRepo;

    public CategoryTabController(CategoryRepo categoryRepo){this.categoryRepo = categoryRepo;}

    @GetMapping("categories")
    public List<CategoryIdAndName> getAllCategories(){
        return categoryRepo.findAllCategoryBy();
    }
}
