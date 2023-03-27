package com.cookbook.cookbook.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryIdAndNameDto {
    private Long id;
    private String name;
}
