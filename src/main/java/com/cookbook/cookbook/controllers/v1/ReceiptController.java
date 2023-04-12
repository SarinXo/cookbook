package com.cookbook.cookbook.controllers.v1;


import com.cookbook.cookbook.models.receipts.ReceiptPhotoNameShortDescriptionDto;
import com.cookbook.cookbook.models.receipts.ReceiptDto;
import com.cookbook.cookbook.services.ReceiptService;
import org.hibernate.annotations.Parameter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("internal")
public class ReceiptController {

    private final ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @ResponseBody
    @GetMapping("/api/v1/receipt")
    public ReceiptDto getReceiptById(@RequestParam Long id){
        return receiptService.getReceiptById(id);
    }

    @GetMapping("/api/v1/receipts")
    public List<ReceiptPhotoNameShortDescriptionDto> getAllReceipts(){
        return  receiptService.getAllReceipts();

    @GetMapping("/api/v1/receipts/category={categoryId}")
    public List<ReceiptPhotoNameShortDescriptionDto> getCategoryListById(@PathVariable Integer categoryId){
        return receiptService.getReceiptsByCategoryId(categoryId);
    }

}
