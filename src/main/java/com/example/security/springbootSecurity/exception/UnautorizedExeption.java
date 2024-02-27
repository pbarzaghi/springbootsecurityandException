package com.example.security.springbootSecurity.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;


@Data
public class UnautorizedExeption extends RuntimeException{
    private HttpStatus status;

    public UnautorizedExeption(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

}
