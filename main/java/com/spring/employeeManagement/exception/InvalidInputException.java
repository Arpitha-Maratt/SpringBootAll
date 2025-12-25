package com.spring.employeeManagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidInputException extends RuntimeException{

    private final Object resourceId;

    public InvalidInputException(String message,Object resourceId){
        super(message);
        this.resourceId = resourceId;
    }

    public Object getInvalidValue() {
        return resourceId;
    }
}
