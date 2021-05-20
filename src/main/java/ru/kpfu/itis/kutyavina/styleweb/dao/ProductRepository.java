package ru.kpfu.itis.kutyavina.styleweb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.kpfu.itis.kutyavina.styleweb.models.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByType(String type);

    @Query(value = "select distinct product.id as id, composition, description, link, " +
            "product.name as name, path, type from product inner join product_capsule pc " +
            "on product.id = pc.product_id inner join сapsule с on с.id = pc.capsule_id " +
            "where user_id = ?1",
            nativeQuery = true)
    List<Product> getProductByUser(Long userId);

    Product findByName(String name);
}
