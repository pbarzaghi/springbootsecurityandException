package com.example.security.springbootSecurity.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;


public class FieldInvalidException extends BadRequestException{

    public FieldInvalidException(String message, HttpStatus status) {
        super(message, status);
    }
}
