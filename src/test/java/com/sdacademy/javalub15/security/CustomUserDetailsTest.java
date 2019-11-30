package com.sdacademy.javalub15.security;

import com.google.common.collect.Sets;
import com.sdacademy.javalub15.domain.Authority;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.Collection;

import static org.junit.Assert.*;

public class CustomUserDetailsTest {

    private CustomUserDetails customUserDetails;

    @Before
    public void setUp() throws Exception {
        customUserDetails = new CustomUserDetails();
        customUserDetails.setExpireDate(LocalDate.of(2019, 12, 2));
        customUserDetails.setPasswordExpireDate(LocalDate.of(2019, 12, 2));
        customUserDetails.setLocked(false);
        customUserDetails.setAccountEnable(true);
    }

    @Test
    public void testShouldReturnTrueIfAllPropertiesAreCorrect() {
        //given


        //when
        boolean accountNonExpired = customUserDetails.isAccountNonExpired();
        boolean credentialsNonExpired = customUserDetails.isCredentialsNonExpired();
        boolean accountNonLocked = customUserDetails.isAccountNonLocked();
        boolean enabled = customUserDetails.isEnabled();

        //then
        assertTrue(accountNonExpired);
        assertTrue(credentialsNonExpired);
        assertTrue(accountNonLocked);
        assertTrue(enabled);

    }

    @Test
    public void testShouldReturnFalseIfAccountIsExpired() {
        //given
        customUserDetails.setExpireDate(LocalDate.now().minusDays(7));

        //when
        boolean accountNonExpired = customUserDetails.isAccountNonExpired();

        //then
        assertFalse(accountNonExpired);
    }

    @Test
    public void testShouldReturnFalseWhenPasswordIsExpired() {
        //given
        customUserDetails.setPasswordExpireDate(LocalDate.now().minusDays(1));

        //when
        boolean credentialsNonExpired = customUserDetails.isCredentialsNonExpired();

        //then
        assertFalse(credentialsNonExpired);
    }

    @Test
    public void testShouldReturnFalseWhenAccountIsUnenabled() {
        //given
        customUserDetails.setAccountEnable(false);

        //when
        boolean enabled = customUserDetails.isEnabled();

        //then
        assertFalse(enabled);

    }

    @Test
    public void testShouldReturnFalseWhenAccountIsLocked() {
        //given
        customUserDetails.setLocked(true);

        //when
        boolean nonLocked = customUserDetails.isAccountNonLocked();

        //then
        assertFalse(nonLocked);
    }

    @Test
    public void testShouldReturnAuthoritiesSetIfSetExists() {
        //given
        customUserDetails.setAuthoritySet(Sets.newHashSet(new Authority()));

        //when
        Collection<? extends GrantedAuthority> authorities = customUserDetails.getAuthorities();

        //then
        assertNotNull(authorities);
        assertFalse(CollectionUtils.isEmpty(authorities));
    }
}