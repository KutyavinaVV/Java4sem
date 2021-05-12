package ru.kpfu.itis.kutyavina.styleweb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.kutyavina.styleweb.models.Capsule;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CapsuleDto {

    private Long id;
    private String name;
    private UserDto owner;
    private List<String> productList;

    public static CapsuleDto from(Capsule capsule) {
        return CapsuleDto.builder()
                .owner(UserDto.from(capsule.getOwner()))
                .name(capsule.getName())
                .productList(capsule.getProductList().stream().map(product -> product.getName()).collect(Collectors.toList()))
                .id(capsule.getId()).build();
    }

    public static List<CapsuleDto> from(List<Capsule> capsules) {
        return capsules.stream().map(CapsuleDto::from).collect(Collectors.toList());
    }

}
