package com.sdacademy.javalub15.services.implementation;

import com.google.common.collect.Sets;
import com.sdacademy.javalub15.controllers.dtos.UserDTO;
import com.sdacademy.javalub15.domain.Authority;
import com.sdacademy.javalub15.domain.User;
import com.sdacademy.javalub15.repositories.UserRepository;
import com.sdacademy.javalub15.services.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));
        user.setExpireDate(LocalDate.now().plusYears(1));
        user.setPasswordExpireDate(LocalDate.now().plusMonths(6));
        user.setAccountEnable(true);
        Authority authority = new Authority();
        authority.setAuthority("ROLE_USER");
        authority.setUser(user);
        user.setAuthoritySet(Sets.newHashSet(authority));

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

    @Override
    @Transactional
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        // TODO: 23.11.2019 walidacja
        User dbo = userRepository.getOne(id);
        dbo.setEmail(userDTO.getEmail());
        dbo.setPassword(userDTO.getPassword());
        dbo.setUsername(userDTO.getUsername());

        User persistedUSer = userRepository.save(dbo);
        UserDTO dto = new UserDTO(persistedUSer.getUsername(), persistedUSer.getPassword(), persistedUSer.getEmail());
        return dto;
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        // TODO: 23.11.2019 walidacja
        User user = userRepository.getOne(id);
        userRepository.delete(user);
    }

}
