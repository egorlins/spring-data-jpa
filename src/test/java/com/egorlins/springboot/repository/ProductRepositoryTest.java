package com.egorlins.springboot.repository;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.egorlins.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

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

    @Test
    void updateUsingSaveMethod(){

        //find or retrieve any entity by ID
        Long id = 1L;
        Product product = productRepository.findById(id).get();

        //update entity
        product.setName("updated product 1");
        product.setDescription("updated product 1 description");

        //save
        productRepository.save(product);
    }

    @Test
    void findByIdMethod(){
        Long id = 1L;
        Product product = productRepository.findById(id).get();
    }

    @Test
    void saveAllMethod(){
        Product product = new Product();
        product.setName("product2");
        product.setDescription("product 3 description");
        product.setSku("100ABCD");
        product.setPrice(new BigDecimal(200));
        product.setActive(true);
        product.setImageUrl("product2.png");

        Product product3 = new Product();
        product3.setName("product3");
        product3.setDescription("product 3 description");
        product3.setSku("300ABCD");
        product3.setPrice(new BigDecimal(300));
        product3.setActive(true);
        product3.setImageUrl("product3.png");

        productRepository.saveAll(List.of(product,product3));
    }

    @Test
    void findAllMethod(){
        List<Product> products = productRepository.findAll();

        products.forEach((product)->{
            System.out.println(product);
        });
    }

    @Test
    void deleteByIdMethod(){
        Long id = 1L;
        productRepository.deleteById(id);
    }
    @Test
    void deleteMethod(){

        //find or retrieve any entity by ID
        Long id = 2L;
        Product product = productRepository.findById(id).get();

        //delete entity
        productRepository.delete(product);
    }

    @Test
    void deleteAllMethod(){
        productRepository.deleteAll();
    }

    @Test
    void deleteAllMethod2(){
        Product product1 = productRepository.findById(5L).get();
        Product product2 = productRepository.findById(6L).get();
        productRepository.deleteAll(List.of(product1, product2));
    }

    @Test
    void countMethod(){
        long count = productRepository.count();
        System.out.println(count);
    }

    @Test
    void existsByIdMethod2(){
        System.out.println(productRepository.existsById(5L));
        System.out.println(productRepository.existsById(9L));
    }
}