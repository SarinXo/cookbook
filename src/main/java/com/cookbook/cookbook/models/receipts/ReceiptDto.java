package com.cookbook.cookbook.models.receipts;


import com.cookbook.cookbook.models.authors.AuthorDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReceiptDto {
    private String name;
    private String category;
    private String photo;
    private String shortDescription;
    private List<String>  receipt;
    private Double rating;
    private String ingredients;
    private AuthorDto author;
    private Boolean editable;
}
