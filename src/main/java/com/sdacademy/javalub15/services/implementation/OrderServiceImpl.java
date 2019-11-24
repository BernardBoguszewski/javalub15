package com.sdacademy.javalub15.services.implementation;

import com.sdacademy.javalub15.controllers.dtos.OrderDTO;
import com.sdacademy.javalub15.controllers.dtos.OrderRequestDTO;
import com.sdacademy.javalub15.domain.Order;
import com.sdacademy.javalub15.domain.Product;
import com.sdacademy.javalub15.domain.User;
import com.sdacademy.javalub15.repositories.OrderRepository;
import com.sdacademy.javalub15.repositories.UserRepository;
import com.sdacademy.javalub15.services.OrderService;
import com.sdacademy.javalub15.services.ProductService;
import com.sdacademy.javalub15.services.mappers.OrderMapper;
import com.sdacademy.javalub15.services.validators.OrderRequestDTOValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
