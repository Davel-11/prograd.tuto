package com.nebulosa.auth.controller;

import com.nebulosa.auth.dao.UserRepositoryData;
import com.nebulosa.auth.model.UserInfo;
import com.nebulosa.auth.model.UserToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.nebulosa.auth.service.JwtUserDetailsService;


import com.nebulosa.auth.config.JwtTokenUtil;
import com.nebulosa.auth.model.JwtResponse;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    UserRepositoryData userRepositoryData;

    JwtAuthenticationController(UserRepositoryData userRepositoryData) {
        this.userRepositoryData = userRepositoryData;
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<UserToken> createAuthenticationToken(@RequestBody UserInfo user) throws Exception {

        authenticate(user.getEmail(), user.getPassword());

        final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());
        final String token = jwtTokenUtil.generateToken(userDetails);
        JwtResponse tokenData = new JwtResponse(token);

        UserInfo userInfo = this.userRepositoryData.findByEmail(user.getEmail());

        UserToken userToken = new UserToken(userInfo, tokenData);

        //new JwtResponse(token)
        return new ResponseEntity<>( userToken, HttpStatus.OK );
    }

    private void authenticate(String email, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
