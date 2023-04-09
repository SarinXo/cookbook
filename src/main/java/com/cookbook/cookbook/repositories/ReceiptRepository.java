package com.cookbook.cookbook.repositories;

import com.cookbook.cookbook.models.receipts.ReceiptPhotoNameShortDescriptionDto;
import com.cookbook.cookbook.schemas.cookbook.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {

    @Query("SELECT new com.cookbook.cookbook.models.receipts.ReceiptPhotoNameShortDescriptionDto(" +
            "receipt.photo, " +
            "receipt.name, " +
            "receipt.shortDescription) " +
            "FROM Receipt receipt " +
            "WHERE receipt.categoryId.id = :categoryId")
    List<ReceiptPhotoNameShortDescriptionDto> getReceiptsByCategoryId(
            @Param("categoryId") Integer categoryId
    );

}
