package com.arpitha.taskManagementSystem.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class InvalidInputException extends RuntimeException{
    private final Object resourceId;

    public InvalidInputException(String message,Object resourceId){
        super(message);
        this.resourceId=resourceId;
    }


    public Object getResourceId(){
        return resourceId;
    }

}
