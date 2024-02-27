package com.example.security.springbootSecurity.controller;

import com.example.security.springbootSecurity.dto.UserDto;

import com.example.security.springbootSecurity.exception.BadRequestException;
import com.example.security.springbootSecurity.exception.NotFoundException;
import com.example.security.springbootSecurity.service.UserService;
import lombok.RequiredArgsConstructor;

import org.mapstruct.control.MappingControl;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/users")
public class UserController {


    private final UserService userService  ;
   @GetMapping
   public ResponseEntity<List<UserDto>> getAllUser(){
   try {
         return ResponseEntity.ok(userService.findAll());
   }catch ( Exception e){
       throw new BadRequestException("FALLO POR ALGO",HttpStatus.CONFLICT);
   }
    }
    @GetMapping("/{id}")
    public ResponseEntity< UserDto> getUserById(@PathVariable Long id){
       Optional<UserDto> opUserDto= userService.findById(id) ;
        if (opUserDto.get() != null)
            return   ResponseEntity.ok(opUserDto.get() );

        throw (new NotFoundException("User not found",HttpStatus.NOT_FOUND));

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@RequestBody UserDto userDto){
        userService.save(  userDto );

    }    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void udateUser(@RequestBody UserDto userDto){
        userService.update( userDto);

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





}
