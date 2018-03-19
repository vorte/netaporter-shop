package com.netaporter.shop;


import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BasketTest {

    private Basket basket;
    private Product product1;
    private Product product2;

    @Before
    public void setUp() throws Exception {
        basket = new Basket();

        product1 = new Product(1, "product 1", new BigDecimal(23.50));
        product2 = new Product(2, "product 2", new BigDecimal(14.80));
    }

    @Test
    public void total() {
        basket.addProduct(product1);
        basket.addProduct(product1);
        basket.addProduct(product2);

        assertThat(basket.getTotal().setScale(2, BigDecimal.ROUND_HALF_UP)
                .equals(new BigDecimal(61.80).setScale(2, BigDecimal.ROUND_HALF_UP)), is(true));
    }

    @Test
    public void total_remove() {
        basket.addProduct(product1);
        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.removeProduct(product1);

        assertThat(basket.getTotal().setScale(2, BigDecimal.ROUND_HALF_UP)
                .equals(new BigDecimal(38.30).setScale(2, BigDecimal.ROUND_HALF_UP)), is(true));
    }

}