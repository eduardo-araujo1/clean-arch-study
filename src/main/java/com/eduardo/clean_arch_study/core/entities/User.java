package com.eduardo.clean_arch_study.core.entities;

import com.eduardo.clean_arch_study.core.enums.UserType;

public record User(
        Long id,
        String username,
        String email,
        String cpf,

        UserType type

) {
}
