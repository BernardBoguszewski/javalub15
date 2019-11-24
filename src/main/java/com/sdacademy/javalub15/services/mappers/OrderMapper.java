package com.sdacademy.javalub15.services.mappers;

import com.google.common.collect.Lists;
import com.sdacademy.javalub15.controllers.dtos.OrderDTO;
import com.sdacademy.javalub15.domain.Order;
import org.springframework.util.CollectionUtils;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class OrderMapper {

    public static OrderDTO mapToDto(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        if (order.getUser() != null) {
            orderDTO.setUserId(order.getUser().getId());
        }
        if (!CollectionUtils.isEmpty(order.getProducts())) {
            List<Long> productIds = Lists.newArrayList();
            order.getProducts().forEach(product -> {
                productIds.add(product.getId());
            });
            orderDTO.setProductIds(productIds);
        }
        orderDTO.setCreateDate(order.getCreateDate().format(DateTimeFormatter.ISO_DATE));

        return orderDTO;
    }
}
