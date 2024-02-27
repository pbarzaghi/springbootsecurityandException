package com.example.security.springbootSecurity.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ConflictException extends  RuntimeException{
    private HttpStatus status;

    public ConflictException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
