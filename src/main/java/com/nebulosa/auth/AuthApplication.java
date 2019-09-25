package com.nebulosa.auth;

import com.nebulosa.auth.dao.CategoryRep;
import com.nebulosa.auth.dao.CourseRep;
import com.nebulosa.auth.dao.UserRepository;
import com.nebulosa.auth.model.Category;
import com.nebulosa.auth.service.JwtUserDetailsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AuthApplication {

	static UserRepository userRepository;
	static JwtUserDetailsService jwtUserDetailsService;
	static PasswordEncoder passwordEncoder;
	static CourseRep courseRep;
	static CategoryRep categoryRep;


	AuthApplication(
			UserRepository userRepository,
			JwtUserDetailsService jwtUserDetailsService,
			PasswordEncoder passwordEncoder,
			CourseRep courseRep,
			CategoryRep categoryRep) {
		this.userRepository = userRepository;
		this.jwtUserDetailsService = jwtUserDetailsService;
		this.passwordEncoder = passwordEncoder;
		this.courseRep = courseRep;
		this.categoryRep = categoryRep;
	}

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);


		System.out.println("xx" + courseRep.findAll() );

		//System.out.println("xx" + categoryRep.findAll() );

	}

}
