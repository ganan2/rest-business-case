package com.pseudoRest.load;

import com.pseudoRest.domain.Product;
import com.pseudoRest.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/** The type LoadProducts */
public class LoadProducts implements ApplicationListener<ContextRefreshedEvent> {

    /** The product repository */
    @Autowired
    private ProductRepository productRepository;

    /**
     * This method creates products and prints count of products
     *
     * @param contextRefreshedEvent
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        productRepository.save(new Product(15117729L, 12.35f));
        productRepository.save(new Product(16483589L, 23.35f));
        productRepository.save(new Product(16696652L, 51.45f));
        productRepository.save(new Product(16752456L, 13.35f));
        productRepository.save(new Product(15643793L, 13.35f));

        System.out.println(productRepository.count());
    }
}
