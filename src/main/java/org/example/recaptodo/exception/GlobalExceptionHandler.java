package org.example.recaptodo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ToDoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorObject handleToDoNotFoundException(ToDoNotFoundException exception){
        return new ErrorObject(exception.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObject handleRuntimeException(RuntimeException exception){
        return new ErrorObject(exception.getMessage());
    }
}
