package com.example.security.springbootSecurity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
@Builder
@AllArgsConstructor
public class ErrorMessage {
    private String message;
    private HttpStatus status;
}
