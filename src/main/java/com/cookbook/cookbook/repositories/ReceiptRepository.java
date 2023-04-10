package com.cookbook.cookbook.repositories;

import com.cookbook.cookbook.models.receipts.ReceiptPhotoNameShortDescriptionDto;
import com.cookbook.cookbook.schemas.cookbook.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface ReceiptRepository extends JpaRepository<Receipt, Long> {

    Optional<Receipt> findById(Long receiptId);

    @Query("SELECT new com.cookbook.cookbook.models.receipts.ReceiptPhotoNameShortDescriptionDto(receipt.photo, receipt.name, receipt.shortDescription) FROM Receipt receipt")
    List<ReceiptPhotoNameShortDescriptionDto> getAllReceipts();



}
