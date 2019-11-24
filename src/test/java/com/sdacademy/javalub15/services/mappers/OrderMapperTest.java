package com.sdacademy.javalub15.services.mappers;

import com.google.common.collect.Lists;
import com.sdacademy.javalub15.controllers.dtos.OrderDTO;
import com.sdacademy.javalub15.domain.Order;
import com.sdacademy.javalub15.domain.Product;
import com.sdacademy.javalub15.domain.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class OrderMapperTest {

    @Test
    public void testShouldMapOrderToOrderDTO() {
        //given
        Order order = new Order();
        Product product = new Product();
        product.setId(1L);
        List<Product> products = Lists.newArrayList(product);
        order.setProducts(products);
        User user = new User();
        user.setId(5L);
        order.setUser(user);
        order.setCreateDate(LocalDate.of(1901, 6, 7));

        //when
        OrderDTO orderDTO = OrderMapper.mapToDto(order);

        //then
        assertEquals(order.getUser().getId(), orderDTO.getUserId());
        assertEquals(Lists.newArrayList(1L), orderDTO.getProductIds());
        assertEquals(order.getCreateDate().format(DateTimeFormatter.ISO_DATE), orderDTO.getCreateDate());

    }

}