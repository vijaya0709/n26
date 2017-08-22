package com.transactions.controller;

import com.sun.media.sound.InvalidDataException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@ControllerAdvice
public class DefaultControllerAdvice {

    @ResponseStatus(NO_CONTENT)
    @ExceptionHandler(InvalidDataException.class)
    public void handleMethodArgumentNotValidException() {
    }

}
