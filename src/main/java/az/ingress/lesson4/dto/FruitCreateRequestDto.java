package az.ingress.lesson4.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class FruitCreateRequestDto {
    @NotBlank
    private String name;
    @NotBlank
    private String amount;
    @NotNull
    @Positive
    private BigDecimal price;
}
