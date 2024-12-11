package com.eduardo.clean_arch_study.infrastructure.configuration;

import com.eduardo.clean_arch_study.core.gateways.UserGateway;
import com.eduardo.clean_arch_study.core.usecases.CreateUserUseCase;
import com.eduardo.clean_arch_study.core.usecases.FindAllUseCase;
import com.eduardo.clean_arch_study.core.usecases.impl.CreateUserUseCaseImpl;
import com.eduardo.clean_arch_study.core.usecases.impl.FindAllUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public CreateUserUseCase createUserUseCase (UserGateway userGateway) {
        return new CreateUserUseCaseImpl(userGateway);
    }

    @Bean
    public FindAllUseCase findAllUseCase(UserGateway userGateway) {
        return new FindAllUseCaseImpl(userGateway);
    }
}
