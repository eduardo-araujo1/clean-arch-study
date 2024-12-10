package com.eduardo.clean_arch_study.core.usecases.impl;

import com.eduardo.clean_arch_study.core.entities.User;
import com.eduardo.clean_arch_study.core.gateways.UserGateway;
import com.eduardo.clean_arch_study.core.usecases.CreateUserUseCase;

import java.util.Optional;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserGateway userGateway;

    public CreateUserUseCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User create(User user) {
        userGateway.findByCpfCnpj(user.cpfOrCnpj())
                .ifPresent(existingUser -> {
                    throw new RuntimeException("O CPF/CNPJ " + user.cpfOrCnpj() + " já está cadastrado no sistema");
                });
        return userGateway.createUser(user);
    }
}
