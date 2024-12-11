package com.eduardo.clean_arch_study.core.usecases.impl;

import com.eduardo.clean_arch_study.core.entities.User;
import com.eduardo.clean_arch_study.core.exceptions.BusinessException;
import com.eduardo.clean_arch_study.core.gateways.UserGateway;
import com.eduardo.clean_arch_study.core.usecases.CreateUserUseCase;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserGateway userGateway;

    public CreateUserUseCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User execute(User user) {
        userGateway.findByCpf(user.cpf())
                .ifPresent(existingUser -> {
                    throw new BusinessException("O CPF: " + user.cpf() + " já está cadastrado no sistema");
                });
        return userGateway.createUser(user);
    }
}
