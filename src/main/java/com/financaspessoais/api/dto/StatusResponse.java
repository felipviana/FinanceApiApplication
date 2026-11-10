package com.financaspessoais.api.dto;

public record StatusResponse(
    String nome,
    String versao,
    String status,
    String ambiente
) {}
