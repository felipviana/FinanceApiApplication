package com.financaspessoais.api.exception;

public class AccountNotFoundException extends RuntimeException{
    
    public AccountNotFoundException(Long id) {
        super("Account with ID " + id + " was not found");
    }
}
