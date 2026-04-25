package com.example.helloworld.model;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Standard API Response wrapper
 */
public class ApiResponse {
    private String message;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;
    
    private String method;
    private int statusCode;

    public ApiResponse(String message, LocalDateTime timestamp, String method, int statusCode) {
        this.message = message;
        this.timestamp = timestamp;
        this.method = method;
        this.statusCode = statusCode;
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "message='" + message + '\'' +
                ", timestamp=" + timestamp +
                ", method='" + method + '\'' +
                ", statusCode=" + statusCode +
                '}';
    }
}
