package ru.kpfu.itis.kutyavina.styleweb.servise;

import ru.kpfu.itis.kutyavina.styleweb.models.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProductByType(String type);
}
