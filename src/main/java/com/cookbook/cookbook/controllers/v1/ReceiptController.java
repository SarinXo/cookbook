package com.cookbook.cookbook.controllers.v1;

import com.cookbook.cookbook.models.receipts.ReceiptPhotoNameShortDescriptionDto;
import com.cookbook.cookbook.services.ReceiptService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("internal/api")
public class ReceiptController {

    private final ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @GetMapping("/v1/receipts/category={categoryId}")
    public List<ReceiptPhotoNameShortDescriptionDto> getCategoryListById(@PathVariable Integer categoryId){
        return receiptService.getReceiptsByCategoryId(categoryId);
    }

}