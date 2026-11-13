package com.financaspessoais.api.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.financaspessoais.api.model.Account;
import com.financaspessoais.api.repository.AccountRepository;
import com.financaspessoais.api.exception.AccountNotFoundException;
import com.financaspessoais.api.dto.UpdateAccountRequest;

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

    public Account findAccountById(Long id) {
        return accountRepository.findById(id)
            .orElseThrow(() -> new AccountNotFoundException(id));
    }

    public Account updateAccount(Long id, UpdateAccountRequest request) {
        Account account = findAccountById(id);

        account.update(request.name(), request.type(), request.initialBalance());

        return accountRepository.save(account);
    }

    public void deleteAccount(Long id) {
        Account account = findAccountById(id);

        accountRepository.delete(account);
    }
}
