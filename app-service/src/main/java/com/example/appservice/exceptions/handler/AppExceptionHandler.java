package com.example.appservice.exceptions.handler;

import com.example.appservice.exceptions.NotFoundRuntimeException;
import org.openapitools.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { NotFoundRuntimeException.class })
    protected ResponseEntity<Error> handleExceptionNotFound(RuntimeException ex, WebRequest request) {
        return new ResponseEntity<>(new Error(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = { Exception.class })
    protected ResponseEntity<Error> handleException(RuntimeException ex, WebRequest request) {
        return new ResponseEntity<>(new Error(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

}