package com.netaporter.shop;

import java.util.HashMap;
import java.util.Map;

public class ProductList {

    private Map<Integer, Product> contents;

    public ProductList() {
        contents = new HashMap<>();
    }

    public void add(Product product) {
        contents.put(product.getId(), product);
    }

    public Product get(int productId) {
        return contents.get(productId);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Id, Name, Price");
        for (Product product: contents.values()) {
            builder.append("\n");
            builder.append(product.toString());
        }
        return builder.toString();
    }

}
