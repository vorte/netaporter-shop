package com.netaporter.shop;

import org.junit.Before;
import org.junit.Test;

public class ProductParserTest {

    private ProductParser parser;

    @Before
    public void setUp() {
        this.parser = new ProductParser();
    }

    @Test
    public void parse() throws Exception {
        parser.parse("product-data.csv");
    }

    @Test(expected = NumberFormatException.class)
    public void parse_invalidFile() throws Exception {
        parser.parse("other-file.csv");
    }

}