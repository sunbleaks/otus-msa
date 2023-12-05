package com.example.orderservice.exceptions.handler;

import com.example.orderservice.exceptions.NotFoundRuntimeException;
import com.example.orderservice.exceptions.UniqueRequestRuntimeException;
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

    @ExceptionHandler(value = { UniqueRequestRuntimeException.class })
    protected ResponseEntity<Error> handleExceptionUniqueRequest(RuntimeException ex, WebRequest request) {
        return new ResponseEntity<>(new Error(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = { Exception.class })
    protected ResponseEntity<Error> handleException(RuntimeException ex, WebRequest request) {
        return new ResponseEntity<>(new Error(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
