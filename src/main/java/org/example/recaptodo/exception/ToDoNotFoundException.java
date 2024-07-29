package org.example.recaptodo.exception;

public class ToDoNotFoundException extends RuntimeException{
    public ToDoNotFoundException(String message){
        super(message);
    }
}
