package com.example.security.springbootSecurity.controller;

import com.example.security.springbootSecurity.dto.UserDto;
import com.example.security.springbootSecurity.model.AuthenticationResponse;
import com.example.security.springbootSecurity.service.impl.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {
    private final AuthenticationService authService;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody UserDto request
    ) {
        return ResponseEntity.ok(authService.register(request

        ));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody UserDto request
    ) {
        return ResponseEntity.ok(authService.authenticate(request));
    }

}
