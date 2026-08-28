package com.personalfinance.backend.service;

import com.personalfinance.backend.dto.CreateTransactionRequest;
import com.personalfinance.backend.model.SourceType;
import com.personalfinance.backend.model.Transaction;
import com.personalfinance.backend.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction create(CreateTransactionRequest request) {

        Transaction transaction = new Transaction(
                request.merchant(), 
                request.amount(),
                request.transactionDate(),
                request.category(),
                SourceType.MANUAL,
                OffsetDateTime.now()
        ); 

        return transactionRepository.save(transaction);
    }
}