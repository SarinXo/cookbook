package com.cookbook.cookbook.repositories;

import com.cookbook.cookbook.schemas.cookbook.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

    List<CategoryIdAndName> findAllCategoryBy();
}
