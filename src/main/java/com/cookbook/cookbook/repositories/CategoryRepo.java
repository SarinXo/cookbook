package com.cookbook.cookbook.repositories;

import com.cookbook.cookbook.model.CategoryIdAndNameDto;
import com.cookbook.cookbook.schemas.cookbook.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

    @Query("select new com.cookbook.cookbook.model.CategoryIdAndNameDto(c.id, c.name) from Category c ")
    List<CategoryIdAndNameDto> findData();
}