package com.personalfinance.backend.controller;

import com.personalfinance.backend.dto.CreateTransactionRequest;
import com.personalfinance.backend.model.Transaction;
import com.personalfinance.backend.service.TransactionService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/transactions")
public class TransactionController {
    
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Transaction createTransaction(
        @Valid 
        @RequestBody 
        CreateTransactionRequest request
    ) {
        return transactionService.create(request);
    }
}