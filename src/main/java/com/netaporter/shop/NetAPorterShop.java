package com.netaporter.shop;

import java.io.IOException;

public class NetAPorterShop {

    private ProductList productList;
    private Basket basket;

    public NetAPorterShop() {
        basket = new Basket();
    }

    public void loadProducts() {
        ProductParser parser = new ProductParser();

        try {
            this.productList = parser.parse("product-data.csv");
        } catch (IOException | NumberFormatException ex) {
            System.out.println("Could not load products from file");
            System.exit(1);
        }
    }

    public void listProducts() {
        System.out.println(productList);
    }

    /**
     * Add a product to the Basket
     */
    public void addProductToBasket(int productId) {
        Product product = productList.get(productId);
        if (product == null) {
            System.out.println("Invalid product id " + productId);
        } else {
            basket.addProduct(product);
        }
    }

    /**
     * Remove a product from the Basket
     */
    public void removeProductFromBasket(int productId) {
        Product product = productList.get(productId);
        if (product == null) {
            System.out.println("Invalid product id " + productId);
        } else {
            boolean success = basket.removeProduct(product);
            if (!success) {
                System.out.println(String.format("Product %d not in basket", productId));
            }
        }
    }

    /**
     * Return the total value of the products in the basket
     */
    public void getTotal() {
        System.out.println("Basket value: £" + basket.getTotal());
    }

}
