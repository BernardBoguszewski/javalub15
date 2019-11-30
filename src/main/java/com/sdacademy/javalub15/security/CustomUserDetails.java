package com.sdacademy.javalub15.security;

import com.sdacademy.javalub15.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;

public class CustomUserDetails extends User implements UserDetails {

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getAuthoritySet();
    }

    @Override
    public boolean isAccountNonExpired() {
        if (LocalDate.now().isEqual(getExpireDate())) {
            return true;
        }
        if (LocalDate.now().isBefore(getExpireDate())) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !isLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        if (LocalDate.now().isEqual(getPasswordExpireDate())) {
            return false;
        }
        if (LocalDate.now().isBefore(getPasswordExpireDate())) {
            return true;
        }

        return false;
    }

    @Override
    public boolean isEnabled() {
        return isAccountEnable();
    }
}
