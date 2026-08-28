package com.personalfinance.backend;

import com.personalfinance.backend.dto.CreateTransactionRequest;
import com.personalfinance.backend.model.Category;
import com.personalfinance.backend.model.SourceType;
import com.personalfinance.backend.model.Transaction;
import com.personalfinance.backend.service.TransactionService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TransactionServiceTest {

    @Autowired
    private TransactionService transactionService;

    @Test
    void shouldCreateManualTransaction() {

        CreateTransactionRequest request =
                new CreateTransactionRequest(
                        "Example Cafe",
                        new BigDecimal("18.50"),
                        LocalDate.of(2026, 8, 27),
                        Category.DINING
                );

        Transaction saved = transactionService.create(request);

        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getMerchant()).isEqualTo("Example Cafe");
        assertThat(saved.getSourceType()).isEqualTo(SourceType.MANUAL);
        assertThat(saved.getCreatedAt()).isNotNull();
    }
}