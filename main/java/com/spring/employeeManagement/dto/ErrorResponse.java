package com.spring.employeeManagement.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {

    private String message;
    private int status;
    private String errorCode;
    private Object requestId;
    private LocalDateTime  timestamp= LocalDateTime.now();

    public ErrorResponse(String message, String errorCode, int status, Object requestId) {
        this.message = message;
        this.errorCode = errorCode;
        this.status = status;
        this.requestId = requestId;

    }
}
