package com.matiasleiva.fibonacci.model.service;

import com.matiasleiva.fibonacci.model.dto.FibonacciDto;
import com.matiasleiva.fibonacci.model.dto.FibonacciEstadisticaDto;
import org.springframework.http.ResponseEntity;

public interface FibonacciService {
    public ResponseEntity<FibonacciDto> obtenerEnesimo(Long enesimo);

    public ResponseEntity<FibonacciEstadisticaDto> obtenerEstadistica(Long numero);
}
