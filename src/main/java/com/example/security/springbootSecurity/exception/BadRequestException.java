package com.example.security.springbootSecurity.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
public class BadRequestException extends RuntimeException{
    private HttpStatus status;

    public BadRequestException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
