package com.matiasleiva.fibonacci.model.repository;

import com.matiasleiva.fibonacci.model.bo.FibonacciEstadistica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FibonacciEstadisticaRepository extends JpaRepository<FibonacciEstadistica, Long> {

    @Query(value = "select * from fibonacci_estadistica where numero_solicitado=:numero_buscado", nativeQuery = true)
    public FibonacciEstadistica findByNumero(@Param("numero_buscado") Long numero);
}
