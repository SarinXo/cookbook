package com.cookbook.cookbook.services.impl;

import com.cookbook.cookbook.models.receipts.ReceiptPhotoNameShortDescriptionDto;
import com.cookbook.cookbook.repositories.ReceiptRepository;

import com.cookbook.cookbook.services.ReceiptService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReceiptServiceImpl implements ReceiptService {
    private final ReceiptRepository receiptRepository;

    public ReceiptServiceImpl(ReceiptRepository receiptRepository){this.receiptRepository = receiptRepository;}

    public List<ReceiptPhotoNameShortDescriptionDto>
    getReceiptsByCategoryId(Integer categoryId){
        return receiptRepository.getReceiptsByCategoryId(categoryId);
    }


}
