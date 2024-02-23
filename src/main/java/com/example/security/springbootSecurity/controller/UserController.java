package com.example.security.springbootSecurity.controller;

import com.example.security.springbootSecurity.dto.UserDto;
import com.example.security.springbootSecurity.entity.User;
import com.example.security.springbootSecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

//    private ModelMapper modelMapper;
//    private final UserService userService;
//    @GetMapping
//    public ResponseEntity<List<UserDto>> getAllUser(){
//
//
//        List<UserDto> listUserDtos = userService.findAll().stream()
//                .map(entity -> convertirEntityADto(entity, UserDto.class))
//                .collect(Collectors.toList());
//
//
//
//        return   ResponseEntity.ok(listUserDtos);
//
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public void saveUser(@RequestBody UserDto userDto){
//        userService.save(modelMapper.map(userDto, User.class));
//
//    }
//
//
//    // Función para convertir entidad a DTO utilizando ModelMapper
//    private <D, T> D convertirEntityADto(T entity, Class<D> dtoClass) {
//        return modelMapper.map(entity, dtoClass);
//    }
}
