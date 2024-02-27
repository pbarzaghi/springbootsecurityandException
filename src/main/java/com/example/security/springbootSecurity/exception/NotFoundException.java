package com.example.security.springbootSecurity.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
public class NotFoundException extends RuntimeException{
    private HttpStatus status;

    public NotFoundException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
