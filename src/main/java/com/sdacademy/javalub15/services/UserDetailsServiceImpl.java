package com.sdacademy.javalub15.services;

import com.sdacademy.javalub15.domain.User;
import com.sdacademy.javalub15.repositories.UserRepository;
import com.sdacademy.javalub15.security.CustomUserDetails;
import com.sdacademy.javalub15.services.mappers.UserDetailsMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("invalid username or password");
        }

        CustomUserDetails customUserDetails = UserDetailsMapper.mapUserToUserDetails(user);
        return customUserDetails;
    }

}
