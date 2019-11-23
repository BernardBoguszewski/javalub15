package com.sdacademy.javalub15.controllers;

import com.sdacademy.javalub15.controllers.dtos.UserDTO;
import com.sdacademy.javalub15.repositories.UserRepository;
import com.sdacademy.javalub15.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public Long addUser(@RequestBody UserDTO userDTO) {
        return userService.addUser(userDTO);
    }

}
