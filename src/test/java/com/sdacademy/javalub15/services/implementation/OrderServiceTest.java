package com.sdacademy.javalub15.services.implementation;

import com.google.common.collect.Lists;
import com.sdacademy.javalub15.controllers.dtos.OrderRequestDTO;
import com.sdacademy.javalub15.domain.Order;
import com.sdacademy.javalub15.domain.Product;
import com.sdacademy.javalub15.domain.User;
import com.sdacademy.javalub15.repositories.OrderRepository;
import com.sdacademy.javalub15.repositories.UserRepository;
import com.sdacademy.javalub15.services.OrderService;
import com.sdacademy.javalub15.services.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

    private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ProductService productService;


    @Before
    public void setUp() {
        orderService = new OrderServiceImpl(userRepository, productService, orderRepository);
    }

    @Test
    public void testAddingOrder() throws Exception {
        //given
        Mockito.when(userRepository.getOne(Mockito.any())).thenReturn(new User());
        Mockito.when(productService.findProductsByIds(Mockito.any())).thenReturn(Lists.newArrayList());
        Mockito.when(orderRepository.save(Mockito.any())).thenReturn(new Order());
        Long userId = 1L;
        OrderRequestDTO orderRequestDTO = new OrderRequestDTO();
        orderRequestDTO.setProductIds(Lists.newArrayList(1L));

        //when
        orderService.addOrder(1L, orderRequestDTO);

        //then
        Mockito.verify(orderRepository).save(Mockito.any());
        Mockito.verify(productService).findProductsByIds(Mockito.any());
        Mockito.verify(userRepository).getOne(Mockito.any());
    }

    @Test
    public void testGettingOrderValue() throws Exception {
        //given
        Order order = new Order();
        Product product = new Product();
        product.setPrice(new BigDecimal(1));
        order.setProducts(Lists.newArrayList(product));
        Mockito.when(orderRepository.getOne(Mockito.any())).thenReturn(order);

        //when
        orderService.getOrderValue(1L);

        //then
        Mockito.verify(orderRepository).getOne(Mockito.any());

    }


}