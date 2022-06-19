package com.matiasleiva.fibonacci.model.service.impl;

import com.matiasleiva.fibonacci.model.bo.Fibonacci;
import com.matiasleiva.fibonacci.model.repository.FibonacciEstadisticaRepository;
import com.matiasleiva.fibonacci.model.repository.FibonacciRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FibonacciServiceImplTest {
    @Mock
    private FibonacciRepository repository;
    @Mock
    private FibonacciEstadisticaRepository estadisticaRepository;


    @Test
    public void testearRepositoryFibonacci()
    {
        Long numero =10L;
        Fibonacci fibo = Fibonacci.builder().id(10L)
                .numero(24L)
                .build();
        when(repository.obtenerFibonacci(numero)).thenReturn(fibo);
        
    }

}