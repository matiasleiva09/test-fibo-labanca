package com.matiasleiva.fibonacci.rest;

import com.matiasleiva.fibonacci.model.dto.FibonacciDto;
import com.matiasleiva.fibonacci.model.dto.FibonacciEstadisticaDto;
import com.matiasleiva.fibonacci.model.service.impl.FibonacciServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
class FibonacciControllerTest {
    private MockMvc mockMvc;
    @InjectMocks
    private FibonacciController controller;
    @Mock
    private FibonacciServiceImpl service;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .build();
    }

    public ResponseEntity<Object> getResultadoOkFibo() {
        FibonacciDto fibo = FibonacciDto.builder().id(10L).numero(24L).build();
        return new ResponseEntity<Object>(fibo, HttpStatus.OK);
    }

    public ResponseEntity<Object> getEstadisticaOk()
    {
        FibonacciEstadisticaDto fibo = FibonacciEstadisticaDto.builder()
                .id(1L)
                .numero(10L)
                .cantidad(1L)
                .build();
        return new ResponseEntity<Object>(fibo,HttpStatus.OK);
    }

    public ResponseEntity<Object> getResultadoErrorFibo() {
        return new ResponseEntity<Object>(null, HttpStatus.BAD_REQUEST);
    }

    @Test
    void estadoFibonacciEnesimoOk() throws Exception {
        final Long numero = 10L;
        when(service.obtenerEnesimo(numero)).thenReturn(getResultadoOkFibo());
        mockMvc.perform(get("/fibonacci/" + numero)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void estadoEstadisticaOk() throws Exception {
        final Long numero = 10L;
        when(service.obtenerEstadistica(numero)).thenReturn(getEstadisticaOk());
        mockMvc.perform(get("/fibonacci/" + numero + "/estadistica")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void estadoEstadistcaError() throws Exception{
        final Long numero=-1L;
        when(service.obtenerEstadistica(numero)).thenReturn(getResultadoErrorFibo());
        mockMvc.perform(get("/fibonacci/" + numero + "/estadistica")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void estadoFibonacciEnesimoError() throws Exception {
        final Long numero = -1L;
        when(service.obtenerEnesimo(numero)).thenReturn(getResultadoErrorFibo());
        mockMvc.perform(get("/fibonacci/" + numero)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

}
