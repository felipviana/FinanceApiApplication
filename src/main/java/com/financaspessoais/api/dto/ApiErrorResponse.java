package com.financaspessoais.api.dto;

public record ApiErrorResponse(
    int status,
    String message
) {
}
