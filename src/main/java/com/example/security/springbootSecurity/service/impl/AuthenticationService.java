package com.example.security.springbootSecurity.service.impl;

import com.example.security.springbootSecurity.dto.UserDto;
import com.example.security.springbootSecurity.entity.User;
import com.example.security.springbootSecurity.model.AuthenticationResponse;
import com.example.security.springbootSecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(UserDto userDto) {

        // check if user already exist. if exist than authenticate the user
        if(userRepository.findByUsername(userDto.getUsername()).isPresent()) {
            return new AuthenticationResponse(null, "User already exist");
        }

        User user =User.builder()
                .username(userDto.getUsername())
                 .rol(userDto.getRol())
                 .email(userDto.getEmail())
                .firstName(userDto.getFirstName())
                 .lastName(userDto.getLastName())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .build();


        user = userRepository.save(user);

        String jwt = jwtService.generateToken(user);
        return new AuthenticationResponse(jwt, "User registration was successful");

    }

    public AuthenticationResponse authenticate(UserDto userDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userDto.getUsername() ,
                        userDto.getPassword()
                )
        );


        User user = userRepository.findByUsername(userDto.getUsername()).orElseThrow();
        String jwt = jwtService.generateToken(user);
        if(!userDto.getRol().name().equals(user.getRol().name()))
            return new AuthenticationResponse(null,
                    "The "+userDto.getRol().name()+ " Rol does not have permissions");
        return new AuthenticationResponse(jwt, "User login was successful");

    }





}
