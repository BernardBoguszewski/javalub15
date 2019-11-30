package com.sdacademy.javalub15;

import com.google.common.collect.Sets;
import com.sdacademy.javalub15.domain.Authority;
import com.sdacademy.javalub15.domain.User;
import com.sdacademy.javalub15.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;

@SpringBootApplication
public class Javalub15Application implements CommandLineRunner{

	private UserRepository userRepository;

	public Javalub15Application(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Javalub15Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		Authority authority = new Authority();
		authority.setAuthority("ROLE_USER");
		user.setUsername("user@mail.com");
		user.setPassword(new BCryptPasswordEncoder().encode("pass"));
		user.setAuthoritySet(Sets.newHashSet(authority));
		authority.setUser(user);
		user.setExpireDate(LocalDate.of(2019, 12, 2));
		userRepository.save(user);

	}
}
