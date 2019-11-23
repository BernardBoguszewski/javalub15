package com.sdacademy.javalub15.services.implementation;

import com.sdacademy.javalub15.controllers.dtos.UserDTO;
import com.sdacademy.javalub15.domain.User;
import com.sdacademy.javalub15.repositories.UserRepository;
import com.sdacademy.javalub15.services.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    @Transactional
    public List<UserDTO> findAll() {
        List<User> allUsers = userRepository.findAll();
        List<UserDTO> dtos = new ArrayList<>();
        allUsers.forEach(user -> {
            dtos.add(new UserDTO(user.getUsername(), user.getPassword(), user.getEmail()));
        });

        return dtos;
    }

    @Override
    @Transactional
    public UserDTO findById(Long id) throws Exception {
        if (id == null) {
            throw new Exception("no user with id found");
        }

        User user = userRepository.getOne(id);
        UserDTO userDTO = new UserDTO(user.getUsername(), user.getPassword(), user.getEmail());
        return userDTO;
    }
}
