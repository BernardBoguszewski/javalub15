package com.sdacademy.javalub15.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String email;

    private String password;

    private String username;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Authority> authoritySet;

    private LocalDate expireDate;

    private boolean locked;

    private LocalDate passwordExpireDate;

    private boolean accountEnable;

    public User() {
    }

    public User(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Set<Authority> getAuthoritySet() {
        return authoritySet;
    }

    public void setAuthoritySet(Set<Authority> authoritySet) {
        this.authoritySet = authoritySet;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public LocalDate getPasswordExpireDate() {
        return passwordExpireDate;
    }

    public void setPasswordExpireDate(LocalDate passwordExpireDate) {
        this.passwordExpireDate = passwordExpireDate;
    }

    public boolean isAccountEnable() {
        return accountEnable;
    }

    public void setAccountEnable(boolean accountEnable) {
        this.accountEnable = accountEnable;
    }
}
