package az.ingress.lesson4.service;

import az.ingress.lesson4.dto.FruitCreateRequestDto;
import az.ingress.lesson4.dto.FruitResponseDto;
import az.ingress.lesson4.dto.FruitUpdateRequestDto;

import java.util.List;

public interface FruitService {
    List<FruitResponseDto> getAll(Integer from, Integer to);

    FruitResponseDto getById(Long id);

    FruitResponseDto create(FruitCreateRequestDto fruitDto);

    FruitResponseDto updateById(Long id, FruitUpdateRequestDto fruitDto);

    void deleteById(Long id);
}
