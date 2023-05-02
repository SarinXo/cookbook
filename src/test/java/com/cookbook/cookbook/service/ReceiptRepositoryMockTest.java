package com.cookbook.cookbook.service;

import com.cookbook.cookbook.exceptions.NotFoundApiException;
import com.cookbook.cookbook.models.receipts.ReceiptDto;
import com.cookbook.cookbook.repositories.ReceiptRepository;
import com.cookbook.cookbook.schemas.cookbook.Receipt;
import com.cookbook.cookbook.services.ReceiptService;
import com.cookbook.cookbook.services.impl.ReceiptServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;


@ExtendWith({SpringExtension.class})
@Import({ReceiptServiceImpl.class})
public class ReceiptRepositoryMockTest {

    @MockBean
    public ReceiptRepository receiptRepository;

    @Autowired
    ReceiptService receiptService;

    @BeforeEach
    public void initDB(){
        when(receiptRepository.findById(1L)).thenReturn(Optional.of(
                new Receipt(1L,"1","1","1","1","1",
                        1.,true, 1,1, null,
                        null, null))
        );
        when(receiptRepository.findById(5L)).thenThrow(NotFoundApiException.class);

    }

    @Test
    public void getReceiptByIdTest(){
        ReceiptDto receiptDto = receiptService.getReceiptById(1L);
        assertEquals(receiptDto.getName(), "1");
        assertEquals(receiptDto.getRating(), 1.);
    }

    @Test
    public void getReceiptByIdIfNotFoundTest(){
        assertThrows(NotFoundApiException.class, ()->receiptService.getReceiptById(5L));
    }
}
