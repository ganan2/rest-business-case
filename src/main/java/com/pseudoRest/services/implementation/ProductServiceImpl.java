package com.pseudoRest.services.implementation;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.pseudoRest.domain.Product;
import com.pseudoRest.repos.ProductRepository;
import com.pseudoRest.services.ProductService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.pseudoRest.ServiceUtils.ProductServiceConstants.OBJECT_MAPPER;
import static com.pseudoRest.ServiceUtils.ProductServiceConstants.REST_CLIENT;

/** The type Product service implementation */
@Service
public class ProductServiceImpl implements ProductService{

    /** The product repository*/
    private ProductRepository productRepository;

    /**
     * The method posts Json objects with name and ID to HTTPBin and retrieves the same.
     *
     * DESCRIPTION: Testing an HTTP Library can become difficult sometimes. RequestBin is fantastic for testing POST
     * requests, but doesn't let you control the response. This exists to cover all kinds of HTTP scenarios. Additional
     * endpoints are being considered. All endpoint responses are JSON-encoded.
     *
     * @param productId
     * @return
     */
    @Override
    public JsonNode getProductInfoFromExternalService(Long productId) {

        // create Json
        final ObjectNode objectNode = OBJECT_MAPPER.createObjectNode();
        objectNode.put("id", productId);
        objectNode.put("name", generateRandomProductName());

        // post String to HTTPBin
        final String expectingJSONFromHTTPBin = objectNode.toString();

        // obtain the response (Product names) in String
        final String response = REST_CLIENT.post("https://httpbin.org/respose", expectingJSONFromHTTPBin);

        // read the response
        try {
            JsonNode jsonNode = OBJECT_MAPPER.readTree(response);
            final JsonNode json = jsonNode.get("json");
            return json;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * This method generates and returns random product names
     *
     * @return
     */
    @Override
    public String generateRandomProductName() {

        final List<String> strings = new ArrayList<>();
        strings.add("product 1");
        strings.add("product 2");
        strings.add("product 3");
        strings.add("product 4");
        strings.add("product 5");

        return strings.get((int) (Math.random() * strings.size()));

    }

    /**
     * This method uses product info from the Product repository and product name from HTTPBin, and
     * returns response node which consists of product name and info.
     *
     * @param product
     * @param jsonNode
     * @return
     */
    @Override
    public ObjectNode mergeProductInfo(
            Product product,        // Product info from the Paging and sorting repo
            JsonNode jsonNode) {    // Product name from HTTPBin

        // Create a response node consisting of name and price node
        final ObjectNode responseNode = OBJECT_MAPPER.createObjectNode();
        responseNode.put("id", product.getId());
        responseNode.put("name", jsonNode.get("name").asText());

        final ObjectNode priceNode = OBJECT_MAPPER.createObjectNode();
        priceNode.put("value", product.getPriceValue());
        priceNode.put("currency", "USD");

        responseNode.set("current_price", priceNode);

        return responseNode;
    }

    public Product getProduct(Long id){
        return productRepository.findOne(id);
    }

    public Product updateProduct(Product product){
        return productRepository.save(product);
    }

    public ProductRepository getProductRepository(){
        return productRepository;
    }

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
