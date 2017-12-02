package com.pseudoRest.config;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

/** The type Rest client */
public class RestClient {

    /** The rest server */
    private String server = "http://localhost:3000";
    /** The Http Headers */
    private HttpHeaders httpHeaders;
    /** The Rest Template*/
    private RestTemplate restTemplate;
    /** The Http Status */
    private HttpStatus httpStatus;

    /**
     *  This constructor instantiates a Rest Client
     */
    public RestClient(){

        this.httpHeaders = new HttpHeaders();
        this.restTemplate = new RestTemplate();
        httpHeaders.add("Content-Type", "application/json");
        httpHeaders.add("Accept", "*/*");

    }

    /**
     * This method returns GET response
     *
     * @param uri
     * @return
     */
    public String get(String uri){

        HttpEntity<String> httpEntity = new HttpEntity<>("", httpHeaders);
        ResponseEntity<String> responseEntity
                = restTemplate.exchange(server + uri, HttpMethod.GET, httpEntity, String.class);
        this.setHttpStatus(responseEntity.getStatusCode());
        return responseEntity.getBody();

    }

    /**
     * This method returns POST response
     *
     * @param uri
     * @param json
     * @return
     */
    public String post(String uri, String json){

        HttpEntity<String> httpEntity = new HttpEntity<>("", httpHeaders);
        ResponseEntity<String> responseEntity
                = restTemplate.exchange(server + uri, HttpMethod.POST, httpEntity, String.class);
        this.setHttpStatus(responseEntity.getStatusCode());
        return responseEntity.getBody();

    }

    /**
     * This method returns Http status
     *
     * @return
     */
    public HttpStatus getHttpStatus(){
        return httpStatus;
    }

    /**
     * This method sets Http status
     *
     * @param httpStatus
     */
    public void setHttpStatus(HttpStatus httpStatus){
        this.httpStatus = httpStatus;
    }

}