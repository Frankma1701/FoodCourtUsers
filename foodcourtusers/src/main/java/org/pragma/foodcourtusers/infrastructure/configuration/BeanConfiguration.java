package org.pragma.foodcourtusers.infrastructure.configuration;

import lombok.RequiredArgsConstructor;
import org.pragma.foodcourtusers.domain.api.IRoleServicePort;
import org.pragma.foodcourtusers.domain.api.IUserServicePort;
import org.pragma.foodcourtusers.domain.spi.IRolePersistencePort;
import org.pragma.foodcourtusers.domain.spi.IUserPersistencePort;
import org.pragma.foodcourtusers.domain.usecase.RoleUseCase;
import org.pragma.foodcourtusers.domain.usecase.UserUseCase;
import org.pragma.foodcourtusers.infrastructure.output.jpa.adapter.RoleJpaAdapter;
import org.pragma.foodcourtusers.infrastructure.output.jpa.adapter.UserJpaAdapter;
import org.pragma.foodcourtusers.infrastructure.output.jpa.repository.IRoleRepository;
import org.pragma.foodcourtusers.infrastructure.output.jpa.repository.IUserRepository;
import org.pragma.foodcourtusers.infrastructure.output.jpa.mapper.RoleEntityMapper;
import org.pragma.foodcourtusers.infrastructure.output.jpa.mapper.UserEntityMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IUserRepository iUserRepository;
    private final UserEntityMapper userEntityMapper;
    private final IRoleRepository iRoleRepository;
    private final RoleEntityMapper roleEntityMapper;

    @Bean
    public IUserPersistencePort userPersistencePort(){
        return new UserJpaAdapter(iUserRepository,userEntityMapper);
    }

    @Bean
    public IUserServicePort userServicePort(){
        return new UserUseCase(userPersistencePort());
    }

    @Bean
    public IRolePersistencePort iRolePersistencePort(){
        return new RoleJpaAdapter(iRoleRepository,roleEntityMapper);
    }

    @Bean
    public IRoleServicePort roleServicePort(){
        return new RoleUseCase(iRolePersistencePort());
    }



}
