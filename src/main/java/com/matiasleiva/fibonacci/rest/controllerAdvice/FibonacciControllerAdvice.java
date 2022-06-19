package com.matiasleiva.fibonacci.rest.controllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;

@ControllerAdvice
public class FibonacciControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException ex, WebRequest webRequest)
    {
        HashMap<String,Object> data = new HashMap<String,Object>();
        data.put("timestamp",new Date());
        data.put("message",ex.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handleBadRequestException(BadRequestException ex,WebRequest webRequest)
    {
        HashMap<String,Object> data = new HashMap<String,Object>();
        data.put("timestamp", new Date());
        data.put("message",ex.getMessage());
        return new ResponseEntity<>(data,HttpStatus.BAD_REQUEST);
    }
}
