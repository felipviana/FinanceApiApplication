package com.financaspessoais.api.service;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;

@Service 
public class BalanceService {
    
    public BigDecimal calculateBalance(BigDecimal income,BigDecimal expenses) 
    {
        return income.subtract(expenses);
    }

    public String getFinancialStatus(BigDecimal balance){
        int comparison = balance.compareTo(BigDecimal.ZERO);

        if (comparison == 0){
            return "BALANCED";
        } else if (comparison > 0) {
            return "POSITIVE";
        } else {
            return "NEGATIVE";
        }
    }
}
