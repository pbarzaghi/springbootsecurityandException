package com.example.security.springbootSecurity.service.impl;

import com.example.security.springbootSecurity.dto.UserDto;
import com.example.security.springbootSecurity.entity.User;
import com.example.security.springbootSecurity.repository.UserRepository;
import com.example.security.springbootSecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public User save(User  user) {
        return  userRepository.save( user);
    }

    @Override
    public User update(User user) {
        return  userRepository.save( user);
    }
    @Override
    public List<User> findAll() {
       return userRepository.findAll();

    }

    @Override
    public Optional<User> findById(Long aLong) {
        return userRepository.findById(aLong);
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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow( () -> new UsernameNotFoundException("User not found"));
    }



}