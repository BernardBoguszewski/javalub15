package com.sdacademy.javalub15.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
//                .withUser("user@mail.com")
//                .password(passwordEncoder.encode("pass"))
//                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.csrf().disable()
                   .authorizeRequests()
                   .antMatchers("/registration/**")
                   .permitAll()
                   .anyRequest().authenticated()
               .and()
                   .formLogin().loginPage("/login")
                   .defaultSuccessUrl("/dashboard", true)
                   .permitAll();
    }
}
