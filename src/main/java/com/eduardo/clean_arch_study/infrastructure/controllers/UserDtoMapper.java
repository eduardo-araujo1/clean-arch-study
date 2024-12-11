package com.eduardo.clean_arch_study.infrastructure.controllers;

import com.eduardo.clean_arch_study.core.entities.User;
import com.eduardo.clean_arch_study.infrastructure.dtos.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper {

    public UserDto toDto(User user) {
        return new UserDto(user.username(), user.cpf(), user.email(), user.type());
    }

    public User toDomain(UserDto userDto) {
        return new User(null,userDto.username(), userDto.email(), userDto.cpf(), userDto.type());
    }

}
