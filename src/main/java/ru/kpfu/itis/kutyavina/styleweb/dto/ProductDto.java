package ru.kpfu.itis.kutyavina.styleweb.dto;

import lombok.Builder;
import lombok.Data;
import ru.kpfu.itis.kutyavina.styleweb.models.Product;


@Data
@Builder
public class ProductDto {

    private Long id;
    private String name;

    public static ProductDto from(Product product) {
        return ProductDto.builder()
                .name(product.getName())
                .id(product.getId()).build();
    }
//
//    public static List<CapsuleDto> from(List<Capsule> capsules) {
//        return capsules.stream().map(CapsuleDto::from).collect(Collectors.toList());
//    }

}
