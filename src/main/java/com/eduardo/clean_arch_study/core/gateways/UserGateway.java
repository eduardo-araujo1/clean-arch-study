package com.eduardo.clean_arch_study.core.gateways;

import com.eduardo.clean_arch_study.core.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserGateway {
    User createUser(User user);
    Optional<User> findByCpfCnpj(String cpfOrCnpj);
    List<User> findAll();
}
