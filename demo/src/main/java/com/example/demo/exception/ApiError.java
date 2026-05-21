package com.example.demo.exception;

import java.time.LocalDateTime;

public class ApiError {
    private LocalDateTime timestamp;
    private int status;
    private Object errors;

    public ApiError(int status, Object errors){
        this.timestamp=LocalDateTime.now();
        this.status=status;
        this.errors=errors;
    }

    public LocalDateTime getTimestamp(){ return timestamp; }
    public int getStatus(){ return status; }
    public Object getMessage(){ return errors; }

}
