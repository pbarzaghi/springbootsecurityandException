package com.example.security.springbootSecurity.dto;

import com.example.security.springbootSecurity.enumerado.Roles;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String  lastname;
    private String username;
    private String email;
    private Roles rol;
}
