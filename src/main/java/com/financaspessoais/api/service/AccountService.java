package com.financaspessoais.api.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.financaspessoais.api.model.Account;
import com.financaspessoais.api.repository.AccountRepository;

@Service 
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(String name, String type, BigDecimal initialBalance) {
        Account account = new Account(name, type, initialBalance);

        return accountRepository.save(account);
    }

    public List<Account> findAllAccounts() {
        return accountRepository.findAll();
    }
}
