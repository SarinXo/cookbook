package com.cookbook.cookbook.service;

import com.cookbook.cookbook.config.ContainerBase;
import com.cookbook.cookbook.exceptions.NotFoundApiException;
import com.cookbook.cookbook.models.receipts.ReceiptDto;
import com.cookbook.cookbook.repositories.ReceiptRepository;
import com.cookbook.cookbook.schemas.cookbook.Author;
import com.cookbook.cookbook.schemas.cookbook.Category;
import com.cookbook.cookbook.schemas.cookbook.EnergyValue;
import com.cookbook.cookbook.schemas.cookbook.Receipt;
import com.cookbook.cookbook.services.ReceiptService;
import com.cookbook.cookbook.services.impl.ReceiptServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Import({ReceiptServiceImpl.class})
public class ReceiptServiceTest extends ContainerBase {

    @Autowired
    ReceiptRepository receiptRepository;
    @Autowired
    ReceiptService receiptService;

    private Receipt setReceipt(Long id, String name, String shortDescription, String photo,
                               String ingredients, String receipt, Double rating, Boolean editable,
                               Integer cookTime, Integer portion) {
        return new Receipt(
                id,
                name,
                shortDescription,
                photo,
                ingredients,
                receipt,
                rating,
                editable,
                cookTime,
                portion,
                setAuthor(),
                setCategory(),
                setEnergyValue()
        );
    }
    private EnergyValue setEnergyValue(){
        return new EnergyValue(
                22,
                200,
                400,
                500,
                700,
                null
        );
    }

    private Author setAuthor(){

        return new Author(
                "author with receipt ",
                "name",
                "surname",
                null
        );
    }

    private Category setCategory(){

        return new Category(
                0,
                "",
                null
        );

    }

    @BeforeEach
    public void initDB(){
        receiptRepository.saveAll(List.of(
                setReceipt(
                        1L,
                        "first",
                        "shortDescription",
                        "photo reference",
                        "ingredients",
                        "receipt",
                        1.,
                        true,
                        60,
                        1

                ), setReceipt(
                        2L,
                        "second",
                        "shortDescription",
                        "photo reference",
                        "ingredients",
                        "receipt",
                        2.,
                        true,
                        20,
                        2

                ), setReceipt(3L,
                        "third",
                        "shortDescription",
                        "photo reference",
                        "ingredients",
                        "receipt",
                        3.,
                        true,
                        30,
                        3

                )
        ));
    }

    @Test
    public void getReceiptByIdTest(){
        ReceiptDto receiptDto = receiptService.getReceiptById(1L);
        assertEquals(receiptDto.getName(), "first");
        assertEquals(receiptDto.getRating(), 1.);
    }

    @Test
    public void getReceiptByIdIfNotFoundTest(){
        assertThrows(NotFoundApiException.class, ()->receiptService.getReceiptById(5L));
    }

    @Test
    public void getAllReceiptsTest(){
        assertEquals(receiptService.getAllReceipts().size(), 3);
    }

    @Test
    public void getReceiptsByCategoryIdTest(){
        assertEquals(receiptService.getReceiptsByCategoryId(1).size(), 1);
        assertEquals(receiptService.getReceiptsByCategoryId(2).size(), 1);
        assertEquals(receiptService.getReceiptsByCategoryId(3).size(), 1);
        assertTrue(receiptService.getReceiptsByCategoryId(1).isEmpty());
    }




}
