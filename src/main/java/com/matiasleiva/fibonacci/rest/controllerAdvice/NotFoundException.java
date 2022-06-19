package com.matiasleiva.fibonacci.rest.controllerAdvice;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String leyend)
    {
        super(leyend);
    }
}
