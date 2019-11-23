package com.sdacademy.javalub15.services.implementation;

import com.sdacademy.javalub15.controllers.dtos.UserDTO;
import com.sdacademy.javalub15.domain.User;
import com.sdacademy.javalub15.repositories.UserRepository;
import com.sdacademy.javalub15.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    private UserService userService;

    @Before
    public void setUp() {
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    public void testShouldAddUser() {
        User user = new User();
        Mockito.when(userRepository.save(Mockito.any())).thenReturn(new User());

        userService.addUser(new UserDTO());

        Mockito.verify(userRepository, Mockito.atLeastOnce()).save(Mockito.any());
    }
}
