package com.sdacademy.javalub15.repositories;

import com.sdacademy.javalub15.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
