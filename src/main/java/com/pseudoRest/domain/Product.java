package com.pseudoRest.domain;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Float priceValue;
    private String currency;

    public Product(Float priceValue, String currency) {
        this.priceValue = priceValue;
        this.currency = currency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getPriceValue() {
        return priceValue;
    }

    public void setPriceValue(Float priceValue) {
        this.priceValue = priceValue;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}
