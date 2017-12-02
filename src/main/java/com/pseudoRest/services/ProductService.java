package com.pseudoRest.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.pseudoRest.domain.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    public JsonNode getProductInfoFromExternalService(Long productId);

    public String generateRandomProductName();

    public ObjectNode mergeProductInfo(Product product, JsonNode jsonNode);

}
