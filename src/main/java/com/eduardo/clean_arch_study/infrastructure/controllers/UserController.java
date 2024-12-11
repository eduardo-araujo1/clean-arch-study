package com.eduardo.clean_arch_study.infrastructure.controllers;

import com.eduardo.clean_arch_study.core.entities.User;
import com.eduardo.clean_arch_study.core.usecases.CreateUserUseCase;
import com.eduardo.clean_arch_study.core.usecases.FindAllUseCase;
import com.eduardo.clean_arch_study.infrastructure.dtos.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final FindAllUseCase findAllUseCase;
    private final UserDtoMapper userDtoMapper;

    public UserController(CreateUserUseCase createUserUseCase, FindAllUseCase findAllUseCase, UserDtoMapper userDtoMapper) {
        this.createUserUseCase = createUserUseCase;
        this.findAllUseCase = findAllUseCase;
        this.userDtoMapper = userDtoMapper;
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        User newUser = createUserUseCase.execute(userDtoMapper.toDomain(userDto));
        return userDtoMapper.toDto(newUser);
    }

    @GetMapping
    public List<UserDto> findAll() {
        return findAllUseCase.execute()
                .stream()
                .map(userDtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
