package com.example.security.springbootSecurity.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;


public class FieldAlreadyExistException extends ConflictException{

    public FieldAlreadyExistException(String message, HttpStatus status) {
        super(message, status);
    }
}
