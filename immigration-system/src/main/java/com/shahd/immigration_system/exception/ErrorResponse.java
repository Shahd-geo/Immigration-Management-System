package com.shahd.immigration_system.exception;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class ErrorResponse {
    private Date timestamp;
    private int statusCode;
    private HttpStatus status;
    private String error;
    private String message;
    private String path;



}
