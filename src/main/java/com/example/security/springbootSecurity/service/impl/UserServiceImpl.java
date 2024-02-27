package com.example.security.springbootSecurity.service.impl;

import com.example.security.springbootSecurity.dto.UserDto;
import com.example.security.springbootSecurity.entity.User;
import com.example.security.springbootSecurity.exception.FieldAlreadyExistException;
import com.example.security.springbootSecurity.exception.NotFoundException;
import com.example.security.springbootSecurity.mapper.UserMapper;
import com.example.security.springbootSecurity.repository.UserRepository;
import com.example.security.springbootSecurity.service.UserService;
import lombok.RequiredArgsConstructor;
 import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDto save(UserDto  userDto) {
        return UserMapper.mapper.toDto(
                userRepository.save(UserMapper.mapper.toBean(userDto))
        );
    }

    @Override
    public UserDto update(UserDto userDto) {
        return  UserMapper.mapper.toDto(
                userRepository.save( UserMapper.mapper.toBean(userDto))
        );
    }
    @Override
    public List<UserDto> findAll() {

        List<User> userList=userRepository.findAll();
        userList.forEach(p ->System.out.println(p));

  /*   return userRepository.findAll().stream().
               map(usr -> mapper.toDto(usr))
               .collect(Collectors.toList());
*/
        return userList.stream().
                map(usr -> UserMapper.mapper.toDto(usr))
                .collect(Collectors.toList());
    }

    @Override
    public  Optional<UserDto> findById(Long aLong) {

        Optional<User> userOptional = userRepository.findById(aLong);

        return userOptional.map(user ->UserMapper.mapper.toDto(user));
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();

    }

    @Override
    public void deleteById(Long aLong) {
        userRepository.deleteById(aLong);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws FieldAlreadyExistException{
        return userRepository.findByUsername(username).orElseThrow( () ->
               new FieldAlreadyExistException("User already exist", HttpStatus.CONFLICT));
              //  new UsernameNotFoundException("User not found"));
    }



}