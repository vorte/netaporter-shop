package com.netaporter.shop;

import java.math.BigDecimal;

public class Product {

    private int id;
    private String name;
    private BigDecimal price;


    public Product(int id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%d, %s, £%.2f", id, name, price.doubleValue());
    }
}
