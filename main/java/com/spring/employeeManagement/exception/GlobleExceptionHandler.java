package com.spring.employeeManagement.exception;

import com.spring.employeeManagement.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobleExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException e) {

        ErrorResponse error = new ErrorResponse(
                e.getMessage(),
                "RESOURCE_NOT_FOUND",
                HttpStatus.NOT_FOUND.value(),
                e.getResourceId()
        );

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<ErrorResponse> handleInvalidInput(InvalidInputException e) {

        ErrorResponse error = new ErrorResponse(
                e.getMessage(),
                "INVALID_INPUT",
                HttpStatus.BAD_REQUEST.value(),
                e.getInvalidValue()
        );

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
