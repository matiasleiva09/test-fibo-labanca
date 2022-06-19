package com.matiasleiva.fibonacci.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FibonacciEstadisticaDto {
    private Long id;
    private Long numero;
    private Long cantidad;
}
