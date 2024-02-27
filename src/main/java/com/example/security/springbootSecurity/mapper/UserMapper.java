package com.example.security.springbootSecurity.mapper;

import com.example.security.springbootSecurity.dto.UserDto;
import com.example.security.springbootSecurity.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")

public interface UserMapper {

    UserMapper mapper= Mappers.getMapper(UserMapper.class);

    UserDto toDto(User user);
    User toBean(UserDto userDto);
}
