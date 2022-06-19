package com.matiasleiva.fibonacci.model.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "fibonacci_estadistica")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FibonacciEstadistica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "numero_solicitado")
    private Long numero;
    @Column
    private Long cantidad;
}
