package com.sdacademy.javalub15.repositories;

import com.sdacademy.javalub15.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
