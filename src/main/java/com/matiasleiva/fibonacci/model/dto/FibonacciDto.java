package com.matiasleiva.fibonacci.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class FibonacciDto {
    private Long id;
    private Long numero;
}
