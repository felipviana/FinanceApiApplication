package com.financaspessoais.api.service;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;

@Service 
public class BalanceService {
    
    public BigDecimal calculateBalance(BigDecimal income,BigDecimal expenses) 
    {
        return income.subtract(expenses);
    }
}
