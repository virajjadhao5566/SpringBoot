package com.learn.spring.boot.learn.sb.error;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message){
        super(message);
    }
}
