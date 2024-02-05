package com.learn.spring.boot.learn.sb.error;

import com.learn.spring.boot.learn.sb.Model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandling
        extends ResponseEntityExceptionHandler {
    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage employeeNotFoundHandler(EmployeeNotFoundException exception){
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
        return message;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage genericExceptionHandler(Exception exception){
        ErrorMessage message = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        return message;
    }
}
