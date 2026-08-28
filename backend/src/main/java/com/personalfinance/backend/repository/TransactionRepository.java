package com.personalfinance.backend.repository;

import com.personalfinance.backend.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository 
        extends JpaRepository<Transaction, Long>{
}