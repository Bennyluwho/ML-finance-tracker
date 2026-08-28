package com.personalfinance.backend;

import com.personalfinance.backend.model.Category;
import com.personalfinance.backend.model.SourceType;
import com.personalfinance.backend.model.Transaction;
import com.personalfinance.backend.repository.TransactionRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository transactionRepository;

    @Test
    void shouldSaveTransaction() {
        Transaction transaction = new Transaction(
                "Example Grocery",
                new BigDecimal("42.81"),
                LocalDate.of(2026, 8, 27),
                Category.GROCERIES,
                SourceType.MANUAL,
                OffsetDateTime.now()
        );

        Transaction saved = transactionRepository.save(transaction);

        Transaction found = transactionRepository
                .findById(saved.getId())
                .orElseThrow();

        assertThat(found.getMerchant()).isEqualTo("Example Grocery");
        assertThat(found.getAmount())
                .isEqualByComparingTo(new BigDecimal("42.81"));
    }
}