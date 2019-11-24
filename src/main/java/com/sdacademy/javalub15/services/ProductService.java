package com.sdacademy.javalub15.services;

import com.sdacademy.javalub15.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> findProductsByIds(List<Long> productIds);
    Product findProductById(Long id);
}
