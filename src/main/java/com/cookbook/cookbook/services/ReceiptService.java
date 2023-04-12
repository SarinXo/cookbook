package com.cookbook.cookbook.services;

import com.cookbook.cookbook.models.receipts.ReceiptDto;
import com.cookbook.cookbook.models.receipts.ReceiptPhotoNameShortDescriptionDto;

import java.util.List;

public interface ReceiptService {

    ReceiptDto getReceiptById(Long id);

    List<ReceiptPhotoNameShortDescriptionDto> getAllReceipts();

    List<ReceiptPhotoNameShortDescriptionDto> getReceiptsByCategoryId(
            Integer categoryId
    );

}
