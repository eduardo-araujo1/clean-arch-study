package com.eduardo.clean_arch_study.core.entities;

import com.eduardo.clean_arch_study.core.enums.UserType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record User(
        Long id,
        String username,
        String cpfOrCnpj,
        String email,
        @Enumerated(EnumType.STRING)
        UserType type

) {
}
