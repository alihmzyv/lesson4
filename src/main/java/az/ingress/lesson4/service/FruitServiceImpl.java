package az.ingress.lesson4.service;

import az.ingress.lesson4.domain.FruitEntity;
import az.ingress.lesson4.dto.FruitCreateRequestDto;
import az.ingress.lesson4.dto.FruitResponseDto;
import az.ingress.lesson4.dto.FruitUpdateRequestDto;
import az.ingress.lesson4.repository.FruitRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class FruitServiceImpl implements FruitService {

    private final FruitRepository fruitRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<FruitResponseDto> getAll(Integer from, Integer to) {
        return fruitRepository.findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, FruitResponseDto.class))
                .toList();
    }

    @Override
    public FruitResponseDto getById(Long id) {
        return fruitRepository.findById(id)
                .map(entity -> modelMapper.map(entity, FruitResponseDto.class))
                .orElseThrow(() -> new RuntimeException(String.format("Fruit not found with id: %s", id))); //custom not found exception can be added. the message would be internationalized normally
    }

    @Override
    public FruitResponseDto create(FruitCreateRequestDto fruitDto) {
        FruitEntity fruit = modelMapper.map(fruitDto, FruitEntity.class);
        FruitEntity fruitSaved = fruitRepository.save(fruit);
        return modelMapper.map(fruitSaved, FruitResponseDto.class);
    }

    @Override
    public FruitResponseDto updateById(Long id, FruitUpdateRequestDto updateRequestDto) {
        Optional<FruitEntity> fruitFound = fruitRepository.findById(id);
        if (fruitFound.isEmpty()) {
            throw new RuntimeException(String.format("Fruit not found with id: %s", id));
        } else {
            FruitEntity fruit = fruitFound.get();
            modelMapper.map(updateRequestDto, fruit);
            fruitRepository.save(fruit);
            return modelMapper.map(fruit, FruitResponseDto.class);
        }
    }

    @Override
    public void deleteById(Long id) {
        fruitRepository.deleteById(id);
    }
}
