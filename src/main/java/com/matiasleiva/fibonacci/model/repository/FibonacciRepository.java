package com.matiasleiva.fibonacci.model.repository;

import com.matiasleiva.fibonacci.model.bo.Fibonacci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FibonacciRepository extends JpaRepository<Fibonacci,Long> {
    @Query(value = "select * from fibonacci where id=:enesimo order by 1 asc",nativeQuery = true)
    public Fibonacci obtenerFibonacci(@Param("enesimo") Long enesimo);
}
