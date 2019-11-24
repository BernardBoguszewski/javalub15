package com.sdacademy.javalub15.services;

import com.sdacademy.javalub15.controllers.dtos.OrderDTO;
import com.sdacademy.javalub15.controllers.dtos.OrderRequestDTO;

import java.math.BigDecimal;

public interface OrderService {
    OrderDTO addOrder(Long id, OrderRequestDTO orderRequestDTO) throws Exception;

    BigDecimal getOrderValue(Long id) throws Exception;

    OrderDTO addProductToOrder(Long id, Long productId) throws Exception;
}
