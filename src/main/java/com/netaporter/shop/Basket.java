package com.netaporter.shop;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Basket {

    private Map<Product, Integer> contents;

    public Basket() {
        contents = new HashMap<>();
    }

    public void addProduct(Product product) {
        if (contents.containsKey(product)) {
            contents.put(product, contents.get(product) + 1);
        } else {
            contents.put(product, 1);
        }
    }

    public boolean removeProduct(Product product) {
        Integer count = contents.get(product);
        if (count == null) {
            return false;
        } else if (count > 1) {
            contents.put(product, count - 1);
        } else {
            contents.remove(product);
        }

        return true;
    }

    public BigDecimal getTotal() {
        BigDecimal total =  BigDecimal.ZERO;

        for (Map.Entry<Product, Integer> entry: contents.entrySet()) {
            BigDecimal basketLineValue = entry.getKey().getPrice().multiply(new BigDecimal(entry.getValue()));
            total = total.add(basketLineValue);
        }

        return total;
    }

}
