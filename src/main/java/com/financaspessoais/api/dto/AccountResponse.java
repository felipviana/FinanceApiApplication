package com.financaspessoais.api.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.financaspessoais.api.model.Account;

public record AccountResponse(
    Long id,
    String name,
    String type,
    BigDecimal initialBalance,
    LocalDateTime createdAt
) {
    public static AccountResponse fromEntity(Account account) {
        return new AccountResponse(
            account.getId(), 
            account.getName(), 
            account.getType(), 
            account.getInitialBalance(), 
            account.getCreatedAt()
        );
    }
}
