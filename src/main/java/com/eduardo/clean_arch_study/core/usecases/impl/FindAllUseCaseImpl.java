package com.eduardo.clean_arch_study.core.usecases.impl;

import com.eduardo.clean_arch_study.core.entities.User;
import com.eduardo.clean_arch_study.core.gateways.UserGateway;
import com.eduardo.clean_arch_study.core.usecases.FindAllUseCase;

import java.util.List;

public class FindAllUseCaseImpl implements FindAllUseCase {

    private final UserGateway userGateway;

    public FindAllUseCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public List<User> execute() {
        return userGateway.findAll();
    }
}
