package com.cookbook.cookbook.services.impl;

import com.cookbook.cookbook.models.categories.CategoryIdAndNameDto;
import com.cookbook.cookbook.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements com.cookbook.cookbook.services.CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryIdAndNameDto> getAllCategories(){
        return categoryRepository.findAllCategories();
    }
}
