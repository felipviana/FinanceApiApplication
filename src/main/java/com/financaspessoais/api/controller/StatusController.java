package com.financaspessoais.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.financaspessoais.api.dto.StatusResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController 
public class StatusController {
    
    @GetMapping("/api/status")
    public StatusResponse verificarStatus() {
        
        return new StatusResponse(
            "Finance API",
            "1.0.0",
            "online",
            "desenvolvimento"
        );
    }
}
