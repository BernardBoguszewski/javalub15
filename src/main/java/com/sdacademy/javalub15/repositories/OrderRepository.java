package com.sdacademy.javalub15.repositories;

import com.sdacademy.javalub15.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long>{
}
