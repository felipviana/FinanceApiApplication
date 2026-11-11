package com.financaspessoais.api.exception;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.financaspessoais.api.dto.ValidationErrorResponse;

@RestControllerAdvice 
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleValidation(
        MethodArgumentNotValidException exception
    ) {
        Map<String, String> errors = new LinkedHashMap<>();

        exception.getBindingResult()
            .getFieldErrors()
            .forEach(error -> errors.putIfAbsent(
                error.getField(),
                error.getDefaultMessage()
            ));

        ValidationErrorResponse response = 
            new ValidationErrorResponse(
                400,
                "Validation failed",
                errors
            );

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(response);
    }
    
}
