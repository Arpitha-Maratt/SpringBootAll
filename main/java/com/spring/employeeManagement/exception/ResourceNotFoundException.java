package com.spring.employeeManagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private final Object resourceId;

    public ResourceNotFoundException(String message,Object resourceId){
        super(message);
        this.resourceId = resourceId;
    }

    public ResourceNotFoundException(String message){
        super(message);
        this.resourceId=null;
    }

    public Object getResourceId() {
        return resourceId;
    }
}
