package com.cookbook.cookbook.services;

import com.cookbook.cookbook.models.categories.CategoryIdAndNameDto;

import java.util.List;

public interface CategoryService {

    List<CategoryIdAndNameDto> getAllCategories();
}
