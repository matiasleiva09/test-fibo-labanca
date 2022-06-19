package com.matiasleiva.fibonacci.model.service.impl;

import com.matiasleiva.fibonacci.model.bo.Fibonacci;
import com.matiasleiva.fibonacci.model.bo.FibonacciEstadistica;
import com.matiasleiva.fibonacci.model.mapper.AppMapper;
import com.matiasleiva.fibonacci.model.repository.FibonacciEstadisticaRepository;
import com.matiasleiva.fibonacci.model.repository.FibonacciRepository;
import com.matiasleiva.fibonacci.model.service.FibonacciService;
import com.matiasleiva.fibonacci.rest.controllerAdvice.BadRequestException;
import com.matiasleiva.fibonacci.rest.controllerAdvice.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class FibonacciServiceImpl implements FibonacciService {
    @Autowired
    private FibonacciRepository repository;
    @Autowired
    private FibonacciEstadisticaRepository repositoryEstadistica;
    @Autowired
    private AppMapper mapper;

    @Override
    public ResponseEntity<Object> obtenerEnesimo(Long enesimo) {
        validacionBasica(enesimo);
        Optional<Fibonacci> resultado = Optional.ofNullable(repository.obtenerFibonacci(enesimo));
        if (!resultado.isEmpty()) {
            Optional<FibonacciEstadistica> fiboEst = Optional.ofNullable(repositoryEstadistica.findByNumero(enesimo));
            if (fiboEst.isEmpty())
                repositoryEstadistica.save(FibonacciEstadistica.builder().numero(enesimo).cantidad(1L).build());
            else
                repositoryEstadistica.save(fiboEst.get());
            return new ResponseEntity<>(mapper.fromObToDto(resultado.get()), HttpStatus.OK);
        } else
            throw new NotFoundException("No se encuentran resultados");
    }

    private void validacionBasica(Long enesimo) {
        if (enesimo == null)
            throw new BadRequestException("el número no puede estar vacío o nulo");
        if (enesimo < 0)
            throw new NotFoundException("Ingrese un número mayor a cero");
    }

    @Override
    public ResponseEntity<Object> obtenerEstadistica(Long numero) {
        validacionBasica(numero);
        Optional<FibonacciEstadistica> est = Optional.ofNullable(repositoryEstadistica.findByNumero(numero));
        if (est.isEmpty())
            throw new NotFoundException("No se ha encontrado datos");
        else
            return new ResponseEntity<>(mapper.fromObToDtoEstadistica(est.get()), HttpStatus.OK);
    }
}
