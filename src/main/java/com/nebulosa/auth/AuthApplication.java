package com.nebulosa.auth;

import com.nebulosa.auth.dao.UserRepository;
import com.nebulosa.auth.service.JwtUserDetailsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AuthApplication {

	static UserRepository userRepository;
	static JwtUserDetailsService jwtUserDetailsService;
	static PasswordEncoder passwordEncoder;




	AuthApplication(UserRepository userRepository, JwtUserDetailsService jwtUserDetailsService, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.jwtUserDetailsService = jwtUserDetailsService;
		this.passwordEncoder = passwordEncoder;
	}

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);

		System.out.println("all is" + userRepository.findAll());

		//String hashedPassword = passwordEncoder.encode("password");
		//jwtUserDetailsService.createUser("userEmail", hashedPassword);

	}

}
