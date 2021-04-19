package ru.kpfu.itis.kutyavina.styleweb.models;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="product")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Component
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String path;
    private String type;
    private String link;
    private String description;
    private String composition;

    @ManyToMany
    @JoinTable(name = "product_capsule",
            joinColumns = {@JoinColumn(name="product_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "capsule_id", referencedColumnName = "id")}
            )
    private List<Capsule> capsuleList;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", type='" + type + '\'' +
                ", link='" + link + '\'' +
                ", description='" + description + '\'' +
                ", composition='" + composition + '\'' +
                '}';
    }
}
