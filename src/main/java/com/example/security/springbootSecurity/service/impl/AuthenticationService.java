package com.example.security.springbootSecurity.service.impl;

import com.example.security.springbootSecurity.dto.UserDto;
import com.example.security.springbootSecurity.entity.User;
import com.example.security.springbootSecurity.model.AuthenticationResponse;
import com.example.security.springbootSecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
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

       //// saveUserToken(jwt, user);

        return new AuthenticationResponse(jwt, "User registration was successful");

    }

}
