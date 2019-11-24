package com.sdacademy.javalub15.services.calculators;

import com.sdacademy.javalub15.domain.Product;

import java.math.BigDecimal;
import java.util.List;

public class OrderValueCalculator {

    public static BigDecimal calculateOrderValue(List<Product> products) {
        BigDecimal sum = new BigDecimal(0);
        for (Product product : products) {
            sum = sum.add(product.getPrice());
        }

        return sum;
    }
}
