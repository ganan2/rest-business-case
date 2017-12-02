package com.pseudoRest.domain;

import javax.persistence.*;

/** The type Product */
@Entity
@Table(name = "products")
public class Product {

    /** The product ID */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** The price value */
    private Float priceValue;

    /** The currency */
    private String currency;

    /**
     * Instantiates product ID and price value
     *
     * @param id            The product ID
     * @param priceValue    The price value
     */
    public Product(Long id, Float priceValue) {
        this.id = id;
        this.priceValue = priceValue;
    }

    /**
     * Returns product ID
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets product ID
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns price value
     *
     * @return
     */
    public Float getPriceValue() {
        return priceValue;
    }

    /**
     * Sets price value
     *
     * @param priceValue
     */
    public void setPriceValue(Float priceValue) {
        this.priceValue = priceValue;
    }

    /**
     * Returns currency
     *
     * @return
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets currency
     *
     * @param currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

}
