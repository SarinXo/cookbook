package com.cookbook.cookbook.repositories;

import com.cookbook.cookbook.models.categories.CategoryIdAndNameDto;
import com.cookbook.cookbook.schemas.cookbook.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("select new com.cookbook.cookbook.models.categories.CategoryIdAndNameDto(c.id, c.name) from Category c ")
    List<CategoryIdAndNameDto> findAllCategories();

}