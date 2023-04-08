package com.cookbook.cookbook.controllers.v1;

import com.cookbook.cookbook.models.receipts.ReceiptDto;
import com.cookbook.cookbook.services.ReceiptService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("internal/api")
public class ReceiptController {

    private final ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @ResponseBody
    @GetMapping("/v1/receipts")
    public ReceiptDto getReceiptById(@RequestParam Long receipt){
        return receiptService.getReceiptById(receipt);
    }

}
