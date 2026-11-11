package com.financaspessoais.api.dto;

import java.math.BigDecimal;

public record BalanceResponse(
    BigDecimal income,
    BigDecimal expenses,
    BigDecimal balance,
    String financialStatus
) {}
