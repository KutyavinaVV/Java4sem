package ru.kpfu.itis.kutyavina.styleweb.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.kutyavina.styleweb.dao.ProductRepository;
import ru.kpfu.itis.kutyavina.styleweb.models.Product;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getProductByType(String type) {
        return productRepository.findByType(type);
    }


}
