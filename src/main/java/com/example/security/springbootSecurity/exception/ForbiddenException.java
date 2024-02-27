package com.example.security.springbootSecurity.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ForbiddenException extends RuntimeException{
    private HttpStatus status;

    public  ForbiddenException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
