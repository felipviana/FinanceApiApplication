package com.financaspessoais.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.financaspessoais.api.dto.CreateAccountRequest;
import com.financaspessoais.api.dto.UpdateAccountRequest;
import com.financaspessoais.api.model.Account;
import com.financaspessoais.api.service.AccountService;

import jakarta.validation.Valid;

@RestController 
@RequestMapping ("/api/accounts")
public class AccountController {
    
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping 
    public List<Account> getAllAccounts() {
        return accountService.findAllAccounts();
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return accountService.findAccountById(id);
    }

    @PostMapping 
    @ResponseStatus (HttpStatus.CREATED)
    public Account createAccount(@Valid @RequestBody  CreateAccountRequest request){
        return accountService.createAccount(request.name(), request.type(), request.initialBalance());
    }

    @PutMapping("/{id}")
    public Account updateAccount(@PathVariable Long id, @Valid @RequestBody UpdateAccountRequest request){
        return accountService.updateAccount(id, request);
    }
}
