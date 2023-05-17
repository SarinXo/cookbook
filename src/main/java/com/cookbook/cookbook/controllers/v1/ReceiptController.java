package com.cookbook.cookbook.controllers.v1;


import com.cookbook.cookbook.models.receipts.ReceiptPhotoNameShortDescriptionDto;
import com.cookbook.cookbook.models.receipts.ReceiptDto;
import com.cookbook.cookbook.services.ReceiptService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public s getReceiptById(@RequestParam Long id){
        return receiptService.getReceiptById(id);
    }

    @GetMapping(value ="/api/v1/receipts")
    public List<ReceiptPhotoNameShortDescriptionDto> getAllReceipts() {
        return receiptService.getAllReceipts();
    }

    @ResponseBody
    @GetMapping(value ="/api/v1/category_id={category_id}/receipts")
    public List<ReceiptPhotoNameShortDescriptionDto>
    getCategoryListById(@PathVariable(name = "category_id") Integer categoryId){
        return receiptService.getReceiptsByCategoryId(categoryId);
    }

}
