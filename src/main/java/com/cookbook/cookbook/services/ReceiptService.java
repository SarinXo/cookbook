package com.cookbook.cookbook.services;

import com.cookbook.cookbook.models.receipts.ReceiptDto;


public interface ReceiptService {

    ReceiptDto getReceiptById(Long id);

}
