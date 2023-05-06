package com.cookbook.cookbook.repository;

import com.cookbook.cookbook.config.ContainerBase;
import com.cookbook.cookbook.repositories.ReceiptRepository;
import com.cookbook.cookbook.schemas.cookbook.Author;
import com.cookbook.cookbook.schemas.cookbook.Category;
import com.cookbook.cookbook.schemas.cookbook.EnergyValue;
import com.cookbook.cookbook.schemas.cookbook.Receipt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReceiptRepositoryTest extends ContainerBase {

    @Autowired
    ReceiptRepository receiptRepository;

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
    @Test
    public void testFindAll() {
        var receipts = receiptRepository.getAllReceipts();
        assertEquals(receipts.size(), 3);

    }

    @Test
    public void testFindById(){

        Receipt first = receiptRepository.findById(1L).get();
        assertEquals(first.getId(), 1L);

        Receipt second = receiptRepository.findById(2L).get();
        assertEquals(second.getId(), 2L);

        Receipt third = receiptRepository.findById(3L).get();
        assertEquals(third.getId(), 3L);

        assertFalse(receiptRepository.findById(4L).isPresent());

    }

    @Test
    public void testGetReceiptsByCategoryId(){

        var list
                = receiptRepository.getReceiptsByCategoryId(1);
        for(var i : list){
            assertEquals(i.getName(), "first");
        }

        var list2
                = receiptRepository.getReceiptsByCategoryId(2);
        for(var i : list2){
            assertEquals(i.getName(), "second");
        }

        var list3
                = receiptRepository.getReceiptsByCategoryId(5);
        assertTrue(list3.isEmpty());

    }


}