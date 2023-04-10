package com.cookbook.cookbook.models.receipts;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReceiptPhotoNameShortDescriptionDto {
    private String photo;
    private String name;
    private String shortDescription;
}
