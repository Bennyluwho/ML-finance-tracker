package com.personalfinance.backend.dto;

import com.personalfinance.backend.model.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CreateTransactionRequest(

    @NotBlank
    String merchant,

    @NotNull
    @Positive
    BigDecimal amount,

    @NotNull
    LocalDate transactionDate,

    @NotNull
    Category category
) {
}