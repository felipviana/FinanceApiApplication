package com.financaspessoais.api.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.financaspessoais.api.dto.BalanceResponse;
import com.financaspessoais.api.service.BalanceService;

@RestController 
@RequestMapping("/api/balance")
public class BalanceController {
    
    private final BalanceService balanceService;

    public BalanceController(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    @GetMapping 
    public BalanceResponse getBalance(@RequestParam BigDecimal income, @RequestParam BigDecimal expenses){
        BigDecimal balance = balanceService.calculateBalance(income, expenses);
        
        String financialStatus = balanceService.getFinancialStatus(balance);
        
        return new BalanceResponse(
            income,
            expenses,
            balance,
            financialStatus
        );
    }
}
