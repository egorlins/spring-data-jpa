package com.egorlins.springboot.repository;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.egorlins.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest //to load full application context, so we can inject any Spring Bean class
//@DataJpaTest //to test Repository components
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod()
    {
        //create Product obj
        Product product = new Product();
        product.setName("product1");
        product.setDescription("product 1 description");
        product.setSku("100ABC");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("product.png");

        //save
        Product savedObject = productRepository.save(product);

        //display Product info
        System.out.println(savedObject.getId());
        System.out.println(savedObject.toString());
    }
}