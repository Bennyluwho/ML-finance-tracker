package com.personalfinance.backend.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String merchant;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal amount;

    @Column(name = "transaction_date", nullable = false)
    private LocalDate transactionDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @Enumerated(EnumType.STRING)
    @Column(name = "source_type", nullable = false)
    private SourceType sourceType;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    protected Transaction() {
    }

    public Transaction(
        String merchant,
        BigDecimal amount,
        LocalDate transactionDate,
        Category category,
        SourceType sourceType,
        OffsetDateTime createdAt
    ) {
        this.merchant = merchant;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.category = category;
        this.sourceType = sourceType;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public String getMerchant() {
        return merchant;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public Category getCategory() {
        return category;
    }

    public SourceType getSourceType() {
        return sourceType;
    } 

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }
}