package com.financaspessoais.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financaspessoais.api.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
    
}
