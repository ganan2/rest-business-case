package com.pseudoRest.ServiceUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pseudoRest.config.RestClient;

public class ProductServiceConstants {

    /** The constant REST_CLIENT */
    public static final RestClient REST_CLIENT = new RestClient();

    /** The constant currency USD */
    public static final String currency = "USD";

    /** The constant OBJECT_MAPPER */
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

}
