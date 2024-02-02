package az.ingress.lesson4.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FruitResponseDto {

    private Long id;

    private String name;

    private String amount;

    private Double price;
}
