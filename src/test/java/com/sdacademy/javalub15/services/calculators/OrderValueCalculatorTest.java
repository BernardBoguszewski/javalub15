package com.sdacademy.javalub15.services.calculators;

import com.google.common.collect.Lists;
import com.sdacademy.javalub15.domain.Product;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class OrderValueCalculatorTest {

    @Test
    public void testShouldCalculateOrderValue() {
        //given
        Product firstProduct = new Product();
        firstProduct.setPrice(new BigDecimal(10));
        Product secondProduct = new Product();
        secondProduct.setPrice(new BigDecimal(17));
        List<Product> products = Lists.newArrayList(firstProduct, secondProduct);

        //when
        BigDecimal orderValue = OrderValueCalculator.calculateOrderValue(products);

        //then
        assertEquals(new BigDecimal(10).add(new BigDecimal(17)), orderValue);

    }
}