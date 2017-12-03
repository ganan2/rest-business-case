package com.pseudoRest.controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.pseudoRest.domain.Product;
import com.pseudoRest.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import static com.pseudoRest.ServiceUtils.ProductServiceConstants.OBJECT_MAPPER;

@Controller
@EnableAutoConfiguration
public class ProductController {

    /** The product service */
    @Autowired
    private ProductService productService;

    /**
     * This method returns products, with name and info included, asynchronously
     *
     * @param productId
     * @return
     */
    @Async
    @GetMapping(value = "/products/{id}", produces = "application/json")
    public Future<ObjectNode> getProduct(final @PathParam("id") Long productId){

        return CompletableFuture.supplyAsync(() -> productService.getProductInfo(productId));
    }

    /**
     * This method saves the product and returns product or null on IOException
     *
     * @param json
     * @param productId
     * @return
     */
    @PutMapping(value = "/products/{id}", produces = "application/json")
    public Product updateProduct(final @RequestBody String json, final @PathParam("id") Long productId){

        final Product product = productService.getProduct(productId);
        try {
            productService.updateProduct(product, OBJECT_MAPPER.readTree(json));
            return product;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
