package com.example.security.springbootSecurity.controller;

import com.example.security.springbootSecurity.dto.UserDto;
import com.example.security.springbootSecurity.entity.User;
import com.example.security.springbootSecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private ModelMapper modelMapper;
    private final UserService userService  ;
   @GetMapping
   public ResponseEntity<List<UserDto>> getAllUser(){


      List<UserDto> listUserDtos= userService.findAll().stream()
               .map(this::mapperDto)
               .collect(Collectors.toList());

        return   ResponseEntity.ok(listUserDtos);

    }
    @GetMapping
    public ResponseEntity< UserDto> getUserById(@PathVariable Long id){
         return   ResponseEntity.ok( mapperDto(userService.findById(id).get()));

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@RequestBody UserDto userDto){
        userService.save( mapper(userDto ));

    }


    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void udateUser(@RequestBody UserDto userDto){
        userService.update( mapper(userDto ));

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)

    public void deleteUser(@PathVariable Long id){
        userService.deleteById(id);

    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)

    public void deleteAll( ){
        userService.deleteAll();

    }


    private User mapper(UserDto userDto){
        return  User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .rol(userDto.getRol())
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .build();
    }
private UserDto mapperDto(User user){
        return  UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .rol(user.getRol())
                .username(user.getUsername())
                .password(user.getPassword())
                .build();

    }


}
