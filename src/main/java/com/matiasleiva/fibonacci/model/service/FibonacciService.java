package com.matiasleiva.fibonacci.model.service;

import org.springframework.http.ResponseEntity;

public interface FibonacciService {
    public ResponseEntity<Object> obtenerEnesimo(Long enesimo);

    public ResponseEntity<Object> obtenerEstadistica(Long numero);
}
