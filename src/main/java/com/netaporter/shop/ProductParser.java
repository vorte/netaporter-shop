package com.netaporter.shop;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;

public class ProductParser {

    public ProductList parse(String fileName) throws IOException, NumberFormatException {
        ProductList productList = new ProductList();

        try (InputStream is = getClass().getClassLoader().getResourceAsStream(fileName)) {
            Iterable<CSVRecord> records = CSVParser.parse(is, StandardCharsets.UTF_8,
                    CSVFormat.EXCEL.withFirstRecordAsHeader());
            for (CSVRecord record : records) {
                int productId = Integer.parseInt(record.get(0).trim());
                String name = record.get(1).trim();
                String priceString = record.get(2).trim();
                BigDecimal price = new BigDecimal(StringUtils.stripStart(priceString, "£"));
                productList.add(new Product(productId, name, price));
            }
        }

        return productList;
    }

}
