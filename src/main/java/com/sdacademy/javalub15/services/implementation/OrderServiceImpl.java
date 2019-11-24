package com.sdacademy.javalub15.services.implementation;

import com.google.common.collect.Lists;
import com.sdacademy.javalub15.controllers.dtos.OrderDTO;
import com.sdacademy.javalub15.controllers.dtos.OrderRequestDTO;
import com.sdacademy.javalub15.domain.Order;
import com.sdacademy.javalub15.domain.Product;
import com.sdacademy.javalub15.domain.User;
import com.sdacademy.javalub15.repositories.OrderRepository;
import com.sdacademy.javalub15.repositories.UserRepository;
import com.sdacademy.javalub15.services.OrderService;
import com.sdacademy.javalub15.services.ProductService;
import com.sdacademy.javalub15.services.calculators.OrderValueCalculator;
import com.sdacademy.javalub15.services.mappers.OrderMapper;
import com.sdacademy.javalub15.services.validators.OrderRequestDTOValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private UserRepository userRepository;

    private ProductService productService;

    private OrderRepository orderRepository;

    public OrderServiceImpl(UserRepository userRepository, ProductService productService, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.productService = productService;
        this.orderRepository = orderRepository;
    }

    @Transactional
    @Override
    public OrderDTO addOrder(Long userId, OrderRequestDTO orderRequestDTO) throws Exception {
        User user = userRepository.getOne(userId);
        if (user == null) {
            throw new Exception("User not found"); // TODO: 24.11.2019 opakowanie we własny wyjątek
        }
        if (!OrderRequestDTOValidator.validate(orderRequestDTO)) {
            throw new Exception("Request is incorrect");
        }

        List<Product> products = productService.findProductsByIds(orderRequestDTO.getProductIds());
        Order order = new Order();
        order.setUser(user);
        order.setCreateDate(LocalDate.now());
        order.setProducts(products);
        orderRepository.save(order);

        OrderDTO orderDTO = OrderMapper.mapToDto(order);
        return orderDTO;
    }

    @Override
    public BigDecimal getOrderValue(Long id) throws Exception {
        if (id == null) {
            throw new Exception("Order id is null");
        }
        Order order = orderRepository.getOne(id);
        if (order == null) {
            throw new Exception("Cannot find order with specified id");
        }

        List<Product> products = order.getProducts();
        if (CollectionUtils.isEmpty(products)) {
            throw new Exception("Empty products");
        }

        BigDecimal orderValue = OrderValueCalculator.calculateOrderValue(products);
        return orderValue;
    }
}
