package com.financaspessoais.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.financaspessoais.api.dto.AccountResponse;

import jakarta.validation.Valid;

@RestController 
@RequestMapping ("/api/accounts")
public class AccountController {
    
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping 
    public List<AccountResponse> getAllAccounts() {
        return accountService.findAllAccounts()
        .stream()
        .map(AccountResponse::fromEntity)
        .toList();
    }

    @GetMapping("/{id}")
    public AccountResponse getAccountById(@PathVariable Long id) {
        Account account = accountService.findAccountById(id);

        return AccountResponse.fromEntity(account);
    }

    @PostMapping 
    public ResponseEntity<AccountResponse> createAccount(@Valid @RequestBody CreateAccountRequest request) {
        Account account = accountService.createAccount(
            request.name(), 
            request.type(), 
            request.initialBalance()
        );

        AccountResponse response = AccountResponse.fromEntity(account);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(response);
    }

    @PutMapping("/{id}")
    public AccountResponse updateAccount(@PathVariable Long id, @Valid @RequestBody UpdateAccountRequest request){
        Account account = accountService.updateAccount(id, request);
        
        return AccountResponse.fromEntity(account);
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);

        return ResponseEntity.noContent().build();
    }
}
