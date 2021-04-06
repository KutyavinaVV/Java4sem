package ru.kpfu.itis.kutyavina.styleweb.models;

import lombok.*;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;

@Entity
@Table(name="account")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String email;
    @NonNull
    private String password;

}
