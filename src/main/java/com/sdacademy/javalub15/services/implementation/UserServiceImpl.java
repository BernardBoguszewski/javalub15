package com.sdacademy.javalub15.services.implementation;

import com.sdacademy.javalub15.controllers.dtos.UserDTO;
import com.sdacademy.javalub15.domain.User;
import com.sdacademy.javalub15.repositories.UserRepository;
import com.sdacademy.javalub15.services.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public Long addUser(UserDTO userDTO) {
        // TODO: 23.11.2019 walidacja dto
        User user = new User(userDTO.getEmail(), userDTO.getPassword(), userDTO.getUsername());

        User persistedUser = userRepository.save(user);
        return persistedUser.getId();
    }
}
