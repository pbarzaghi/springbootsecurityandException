package com.example.security.springbootSecurity.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;


public class MalformedHeaderException extends  BadRequestException{
    public MalformedHeaderException(String message, HttpStatus status) {
        super(message, status);
    }
}
