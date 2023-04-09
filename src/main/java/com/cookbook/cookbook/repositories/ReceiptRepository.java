package com.cookbook.cookbook.repositories;

import com.cookbook.cookbook.schemas.cookbook.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface ReceiptRepository extends JpaRepository<Receipt, Long> {

    Optional<Receipt> findById(Long receiptId);


}
