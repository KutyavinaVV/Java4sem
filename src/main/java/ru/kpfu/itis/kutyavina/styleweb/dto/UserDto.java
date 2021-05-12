package ru.kpfu.itis.kutyavina.styleweb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.kutyavina.styleweb.models.User;

@Data
@Builder
public class UserDto {

    private String name;
    private Long id;
    private String email;

    public static UserDto from(User user) {
        return UserDto.builder().email(user.getEmail()).name(user.getName()).id(user.getId()).build();
    }
}
