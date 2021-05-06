package ru.kpfu.itis.kutyavina.styleweb.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="сapsule")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Capsule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User owner;

    @ManyToMany(mappedBy = "capsuleList")
    private List<Product> productList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Capsule capsule = (Capsule) o;
        return Objects.equals(id, capsule.id) &&
                Objects.equals(name, capsule.name) &&
                Objects.equals(owner, capsule.owner) &&
                Objects.equals(productList, capsule.productList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, owner, productList);
    }

    @Override
    public String toString() {
        return "Capsule{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                ", productList=" + productList +
                '}';
    }
}
