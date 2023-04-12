package com.cookbook.cookbook.services.impl;

import com.cookbook.cookbook.models.receipts.ReceiptPhotoNameShortDescriptionDto;
import com.cookbook.cookbook.exceptions.NotFoundApiException;
import com.cookbook.cookbook.models.authors.AuthorDto;
import com.cookbook.cookbook.models.receipts.ReceiptDto;
import com.cookbook.cookbook.repositories.ReceiptRepository;
import com.cookbook.cookbook.schemas.cookbook.Receipt;
import com.cookbook.cookbook.services.ReceiptService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    private final String CATEGORY_DEFAULT_VALUE = "Категория не установлена";

    private final ReceiptRepository receiptRepository;

    public ReceiptServiceImpl(ReceiptRepository receiptRepository){this.receiptRepository = receiptRepository;}

    @Override
    public ReceiptDto getReceiptById(Long receiptId) {
        return convertReceiptToDto(receiptRepository.findById(receiptId).orElseThrow(
                () -> new NotFoundApiException("Receipt with id " + receiptId + " not found")));
    }

    private ReceiptDto convertReceiptToDto(Receipt receipt){

        ReceiptDto receiptDto = new ReceiptDto();

        receiptDto.setName(receipt.getName());
        receiptDto.setCategory(CATEGORY_DEFAULT_VALUE);
        if (Objects.nonNull(receipt.getCategoryId())) {
            receiptDto.setCategory(receipt.getCategoryId().getName());
        }
        receiptDto.setPhoto(receipt.getPhoto());
        receiptDto.setShortDescription(receipt.getShortDescription());
        //Convert a large string to a list strings
        if (Objects.nonNull(receipt.getReceipt())) {
            receiptDto.setReceipt(
                    parseReceiptStringToList(receipt.getReceipt())
            );
        }
        receiptDto.setRating(receipt.getRating());
        receiptDto.setIngredients(receipt.getIngredients());
        if(Objects.nonNull(receipt.getAuthorId())) {
            receiptDto.setAuthor(new AuthorDto(receipt.getAuthorId()));
        }
        receiptDto.setEditable(receipt.getEditable());

        return receiptDto;
    }

    private List<String> parseReceiptStringToList(String string){
        return Arrays.asList(string.split("        "));//8 spaces. Databases need refactoring
    }

    public List<ReceiptPhotoNameShortDescriptionDto> getAllReceipts(){
        return receiptRepository.getAllReceipts();
    }

    public List<ReceiptPhotoNameShortDescriptionDto>
    getReceiptsByCategoryId(Integer categoryId){
        return receiptRepository.getReceiptsByCategoryId(categoryId);
    }


}
