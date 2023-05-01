package com.cookbook.cookbook.repository;

import com.cookbook.cookbook.config.ContainerBase;
import com.cookbook.cookbook.models.categories.CategoryIdAndNameDto;
import com.cookbook.cookbook.repositories.CategoryRepository;
import com.cookbook.cookbook.schemas.cookbook.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class CategoryRepositoryTest extends ContainerBase {

    @Autowired
    CategoryRepository categoryRepository;

    @BeforeEach
    void initDb() {
        categoryRepository.saveAll(List.of(
                new Category(1, "name1", null),
                new Category(2, "name2", null),
                new Category(3, "name3", null)
        ));
    }

    @Test
    public void testFindAllCategories(){
        List<CategoryIdAndNameDto> list = categoryRepository.findAllCategories();
        assertEquals(list.size(), 3);

        int id = 1;
        for(var categoryDto : list){
            assertEquals(categoryDto.getId(), id);
            id++;
        }

    }

}
