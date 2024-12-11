package com.eduardo.clean_arch_study.infrastructure.gateways;

import com.eduardo.clean_arch_study.core.entities.User;
import com.eduardo.clean_arch_study.infrastructure.persistence.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserEntityMapper {

    public UserEntity toEntity(User user) {
        return new UserEntity(user.id(), user.username(), user.email(), user.cpf(), user.type());
    }

    public User toDomainObj (UserEntity userEntity) {
        return new User(userEntity.getId(), userEntity.getUsername(), userEntity.getEmail(), userEntity.getCpf(), userEntity.getType());
    }
}
