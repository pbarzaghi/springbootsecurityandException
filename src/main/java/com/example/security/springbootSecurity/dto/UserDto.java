package com.example.security.springbootSecurity.dto;

import com.example.security.springbootSecurity.model.Roles;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private Roles rol;
}
