package com.matiasleiva.fibonacci.rest;
import com.matiasleiva.fibonacci.model.service.FibonacciService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fibonacci")
public class FibonacciController {
    @Autowired
    private FibonacciService service;
    @GetMapping("/{enesimo}")
    public ResponseEntity<?> obtenerListaFibonacci(@PathVariable Long enesimo)
    {
        return service.obtenerEnesimo(enesimo);
    }

    @GetMapping("/{enesimo}/estadistica")
    public ResponseEntity<?> obtenerEstadistica(@PathVariable Long enesimo)
    {
        return service.obtenerEstadistica(enesimo);
    }
}
