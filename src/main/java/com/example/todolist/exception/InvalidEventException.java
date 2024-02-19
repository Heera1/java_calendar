package com.example.todolist.exception;

public class InvalidEventException extends RuntimeException {
    public InvalidEventException(String message){
        super(message);
    }
}
