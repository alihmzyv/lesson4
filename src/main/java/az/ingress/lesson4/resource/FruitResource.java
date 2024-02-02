package az.ingress.lesson4.resource;

import az.ingress.lesson4.dto.FruitCreateRequestDto;
import az.ingress.lesson4.dto.FruitResponseDto;
import az.ingress.lesson4.dto.FruitUpdateRequestDto;
import az.ingress.lesson4.service.FruitService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/fruits")
public class FruitResource {
    //TODO: error messages should be internationalized, base response structure should be defined, validation error messages should be handled
    private final FruitService fruitService;

    @GetMapping
    public List<FruitResponseDto> getAll(@RequestParam(value = "from", required = false) Integer from,
                                         @RequestParam(value = "to", required = false) Integer to) {
        return fruitService.getAll(from, to);
    }

    @GetMapping("/{id}")
    public FruitResponseDto get(@PathVariable Long id) {
        return fruitService.getById(id);
    }

    @PostMapping
    public FruitResponseDto create(@Validated @RequestBody FruitCreateRequestDto fruitDto) {
        return fruitService.create(fruitDto);
    }

    @PutMapping("/{id}")
    public FruitResponseDto update(@PathVariable Long id,
                                   @RequestBody FruitUpdateRequestDto fruitDto) {
        return fruitService.updateById(id, fruitDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        fruitService.deleteById(id);
    }
}
