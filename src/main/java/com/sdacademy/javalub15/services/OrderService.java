package com.sdacademy.javalub15.services;

import com.sdacademy.javalub15.controllers.dtos.OrderDTO;
import com.sdacademy.javalub15.controllers.dtos.OrderRequestDTO;

public interface OrderService {
    OrderDTO addOrder(Long id, OrderRequestDTO orderRequestDTO) throws Exception;
}
