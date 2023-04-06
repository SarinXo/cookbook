package com.cookbook.cookbook.services;

import com.cookbook.cookbook.models.receipts.ReceiptPhotoNameShortDescriptionDto;

import java.util.List;

public interface ReceiptService {

    List<ReceiptPhotoNameShortDescriptionDto> getAllReceipts();
}
