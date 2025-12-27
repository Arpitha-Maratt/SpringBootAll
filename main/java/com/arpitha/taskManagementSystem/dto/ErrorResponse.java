package com.arpitha.taskManagementSystem.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ErrorResponse {

    private String message;
    private int status;
    private String errorCode;
    private Object requestId;
    private LocalDateTime localDateTime;

    public ErrorResponse(String message, int status, String errorCode, Object requestId) {
        this.message = message;
        this.status = status;
        this.errorCode = errorCode;
        this.requestId = requestId;
        this.localDateTime = LocalDateTime.now(); // auto-set
    }
}
