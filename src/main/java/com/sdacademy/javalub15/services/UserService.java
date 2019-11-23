package com.sdacademy.javalub15.services;

import com.sdacademy.javalub15.controllers.dtos.UserDTO;

import java.util.List;

public interface UserService {

    Long addUser(UserDTO userDTO);

    List<UserDTO> findAll();

    UserDTO findById(Long id) throws Exception;
}
