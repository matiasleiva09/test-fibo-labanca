package com.matiasleiva.fibonacci.rest.controllerAdvice;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String legend)
    {
        super(legend);
    }
}
