package com.cookbook.cookbook.models.categories;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryIdAndNameDto {
    private Long id;
    private String name;
}
