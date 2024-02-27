package com.example.security.springbootSecurity.exception;

import com.example.security.springbootSecurity.dto.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMessage> handleBadRequestException(BadRequestException ex) {
       return new ResponseEntity<>(getErrorMessage(ex, ex.getStatus()),ex.getStatus());
    }

    @ExceptionHandler(UnautorizedExeption.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<ErrorMessage> handleUnautorizedExeption(UnautorizedExeption ex) {
        return new ResponseEntity<>(getErrorMessage(ex, ex.getStatus()),ex.getStatus());
    }

    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<ErrorMessage> handleConflictException(ConflictException ex) {
        return new ResponseEntity<>(getErrorMessage(ex, ex.getStatus()),ex.getStatus());
    }

    @ExceptionHandler(ForbiddenException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<ErrorMessage> handleForbiddenException(ForbiddenException ex) {
        return new ResponseEntity<>(getErrorMessage(ex, ex.getStatus()),ex.getStatus());
    }
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMessage> handleNotFoundException(NotFoundException ex) {
        return new ResponseEntity<>(getErrorMessage(ex, ex.getStatus()),ex.getStatus());
    }

    @ExceptionHandler(MalformedHeaderException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMessage> handleMalformedHeaderException(MalformedHeaderException ex) {
        return new ResponseEntity<>(getErrorMessage(ex, ex.getStatus()),ex.getStatus());
    }
    @ExceptionHandler(FieldInvalidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMessage> handleFieldInvalidException(FieldInvalidException ex) {
        return new ResponseEntity<>(getErrorMessage(ex, ex.getStatus()),ex.getStatus());
    }

    @ExceptionHandler(FieldAlreadyExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMessage> handleFieldAlreadyExistException(FieldAlreadyExistException ex) {
        return new ResponseEntity<>(getErrorMessage(ex, ex.getStatus()),ex.getStatus());
    }



    private ErrorMessage getErrorMessage( RuntimeException ex,HttpStatus status){
        return   ErrorMessage.builder()
                .message(ex.getMessage())
                .status(status)
                .build();
    }
}
