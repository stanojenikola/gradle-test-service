package com.example.demo.exception;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ErrorResponse extends Throwable {
    private int status;
    private String message;

    // Constructor, getters, and setters
}
