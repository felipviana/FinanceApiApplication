package com.financaspessoais.api.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateAccountRequest(
    
    @NotBlank(message = "Account name is required")
    @Size (max = 100, message = "Account name must have at most 100 characters")
    String name,

    @NotBlank (message = "Account type is required")
    @Size (max = 30, message = "Account type must have at most 30 characters")
    String type,

    @NotNull (message = "Initial balance is required")
    BigDecimal initialBalance
) {
    
}
