package com.sdacademy.javalub15.services.mappers;

import com.sdacademy.javalub15.domain.User;
import com.sdacademy.javalub15.security.CustomUserDetails;

public class UserDetailsMapper {

    public static CustomUserDetails mapUserToUserDetails(User user) {
        if (user == null) {
            return null;
        }

        CustomUserDetails customUserDetails = new CustomUserDetails();
        customUserDetails.setUsername(user.getUsername());
        customUserDetails.setEmail(user.getEmail());
        customUserDetails.setPassword(user.getPassword());
        customUserDetails.setAuthoritySet(user.getAuthoritySet());
        customUserDetails.setOrders(user.getOrders());
        customUserDetails.setExpireDate(user.getExpireDate());
        customUserDetails.setAccountEnable(user.isAccountEnable());
        customUserDetails.setLocked(user.isLocked());
        customUserDetails.setPasswordExpireDate(user.getPasswordExpireDate());

        return customUserDetails;
    }
}
