package com.cookbook.cookbook.models.categories;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryIdAndNameDto {
    private Integer id;
    private String name;
}
