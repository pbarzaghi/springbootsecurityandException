package com.example.security.springbootSecurity.service
        ;

import com.example.security.springbootSecurity.dto.UserDto;
import com.example.security.springbootSecurity.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService  extends CrudService<UserDto,Long>{
}
