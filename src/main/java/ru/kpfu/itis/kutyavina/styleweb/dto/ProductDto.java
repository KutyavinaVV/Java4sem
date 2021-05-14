package ru.kpfu.itis.kutyavina.styleweb.dto;

import lombok.Builder;
import lombok.Data;
import ru.kpfu.itis.kutyavina.styleweb.models.Product;

import java.util.List;
import java.util.stream.Collectors;


@Data
@Builder
public class ProductDto {

    private Long id;
    private String name;
    private String path;
    private String type;
    private String link;
    private String description;
    private String composition;

    public static ProductDto from(Product product) {
        return ProductDto.builder()
                .name(product.getName())
                .id(product.getId())
                .path(product.getPath())
                .type(product.getType())
                .link(product.getLink())
                .description(product.getDescription())
                .composition(product.getComposition()).build();
    }

    public static List<ProductDto> from(List<Product> capsules) {
        return capsules.stream().map(ProductDto::from).collect(Collectors.toList());
    }

}
