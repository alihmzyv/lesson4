package az.ingress.lesson4.dto;

import lombok.Data;

@Data
public class FruitUpdateRequestDto {
    private String name;
    private String amount;
    private Double price;
}
