package com.eduardo.clean_arch_study.core.usecases;

import com.eduardo.clean_arch_study.core.entities.User;

import java.util.List;

public interface FindAllUseCase {
     List<User> execute();
}
