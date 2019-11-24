package com.sdacademy.javalub15.services.implementation;

import com.google.common.collect.Lists;
import com.sdacademy.javalub15.domain.Product;
import com.sdacademy.javalub15.repositories.ProductRepository;
import com.sdacademy.javalub15.services.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public List<Product> findProductsByIds(List<Long> productIds) {
        List<Product> products = Lists.newArrayList();
        productIds.forEach(id -> {
            products.add(findProductById(id));
        });

        return products;
    }

    @Transactional
    @Override
    public Product findProductById(Long id) {
        if (id == null) {
            return null;
        }

        Product product = productRepository.getOne(id);
        return product;
    }
}
