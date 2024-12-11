package com.eduardo.clean_arch_study.infrastructure.gateways;

import com.eduardo.clean_arch_study.core.entities.User;
import com.eduardo.clean_arch_study.core.gateways.UserGateway;
import com.eduardo.clean_arch_study.infrastructure.persistence.UserEntity;
import com.eduardo.clean_arch_study.infrastructure.persistence.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Component
public class UserRepositoryGateway implements UserGateway {

    public final UserRepository repository;
    public final UserEntityMapper mapper;

    public UserRepositoryGateway(UserRepository repository, UserEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public User createUser(User user) {
        UserEntity entity = mapper.toEntity(user);
        UserEntity newUser = repository.save(entity);
        return mapper.toDomainObj(newUser);
    }

    @Override
    public Optional<User> findByCpf(String cpf) {
        return repository.findByCpf(cpf)
                .map(mapper::toDomainObj);
    }

    @Override
    public List<User> findAll() {
        return repository
                .findAll()
                .stream()
                .map(mapper::toDomainObj)
                .collect(Collectors.toList());
    }
}
