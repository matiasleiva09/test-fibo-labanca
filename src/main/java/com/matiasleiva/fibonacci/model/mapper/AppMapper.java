package com.matiasleiva.fibonacci.model.mapper;

import com.matiasleiva.fibonacci.model.bo.Fibonacci;
import com.matiasleiva.fibonacci.model.bo.FibonacciEstadistica;
import com.matiasleiva.fibonacci.model.dto.FibonacciDto;
import com.matiasleiva.fibonacci.model.dto.FibonacciEstadisticaDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppMapper {
    public List<FibonacciDto> fromListObToListDto(List<Fibonacci> list);
    public FibonacciDto fromObToDto(Fibonacci ob);
    public List<FibonacciEstadisticaDto> fromListObToListDtoEstadistica(List<FibonacciEstadistica> list);
    public FibonacciEstadisticaDto fromObToDtoEstadistica(FibonacciEstadistica ob);
}
