package ru.kpfu.itis.kutyavina.styleweb.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.kutyavina.styleweb.dao.CapsuleRepository;
import ru.kpfu.itis.kutyavina.styleweb.dao.ProductRepository;
import ru.kpfu.itis.kutyavina.styleweb.dto.ProductDto;
import ru.kpfu.itis.kutyavina.styleweb.models.Capsule;
import ru.kpfu.itis.kutyavina.styleweb.models.Product;

import java.util.List;

@Service
public class ProductService{

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CapsuleRepository capsuleRepository;

    public List<ProductDto> getProductByType(String type) {
        return ProductDto.from(productRepository.findByType(type));
    }

    public void addProductInList(Long capsuleId, Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(IllegalAccessError::new);
        Capsule capsule = capsuleRepository.findById(capsuleId).orElseThrow(IllegalAccessError::new);
        product.getCapsuleList().add(capsule);
        productRepository.save(product);
    }

    public void removeProductFromList(Long capsuleId, Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(IllegalAccessError::new);
        Capsule capsule = capsuleRepository.findById(capsuleId).orElseThrow(IllegalAccessError::new);
        product.getCapsuleList().remove(capsule);
        productRepository.save(product);
    }

    public List<ProductDto> getCurrentUserProducts(Long id) {
        return ProductDto.from(productRepository.getProductByUser(id));
    }


}
