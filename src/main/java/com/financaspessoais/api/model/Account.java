package com.financaspessoais.api.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table (name = "accounts")
public class Account {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column (nullable = false, length = 100)
    private String name;

    @Column (nullable = false, length = 30)
    private String type;

    @Column(
        name = "initial_balance",
        nullable = false,
        precision = 19,
        scale = 2
    )
    private BigDecimal initialBalance;

    @Column (name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    protected Account() {

    }

    public Account(
        String name,
        String type,
        BigDecimal initialBalance
    ) {
        this.name = name;
        this.type = type;
        this.initialBalance = initialBalance;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public BigDecimal getInitialBalance() {
        return initialBalance;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void update(
        String name,
        String type,
        BigDecimal initialBalance
    ) {
        this.name = name;
        this.type = type;
        this.initialBalance = initialBalance;
    }
}

