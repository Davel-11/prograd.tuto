package com.nebulosa.auth.service;

import java.util.ArrayList;

import com.nebulosa.auth.dao.UserRepository;
import com.nebulosa.auth.dao.UserRepositoryData;
import com.nebulosa.auth.model.UserInfo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    UserRepository userRepository;
    UserRepositoryData userRepositoryData;

    JwtUserDetailsService(
        UserRepository userRepository,
        UserRepositoryData userRepositoryData
        ) {
        this.userRepository = userRepository;
        this.userRepositoryData = userRepositoryData;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserInfo userInfo = userRepositoryData.findByEmail(email);
        if (userInfo.getEmail() != null || !userInfo.getEmail().isEmpty() ) {
            return new User( userInfo.getEmail()  ,  userInfo.getPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("UserInfo not found with username: " + email);
        }
    }

    public boolean createUser (String email, String password) {

        UserInfo userInfo = new UserInfo(email, password);

        System.out.println("user to create is" + userInfo);

        this.userRepository.save(userInfo);

        return false;
    }
}

