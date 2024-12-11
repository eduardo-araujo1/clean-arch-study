package com.eduardo.clean_arch_study.infrastructure.dtos;

import com.eduardo.clean_arch_study.core.enums.UserType;

public record UserDto(
        String username,
        String email,
        String cpf,
        UserType type
) {
}
