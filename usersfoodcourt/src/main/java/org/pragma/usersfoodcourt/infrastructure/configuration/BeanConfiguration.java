package org.pragma.usersfoodcourt.infrastructure.configuration;

import lombok.RequiredArgsConstructor;
import org.pragma.usersfoodcourt.domain.api.IRoleServicePort;
import org.pragma.usersfoodcourt.domain.api.IUserServicePort;
import org.pragma.usersfoodcourt.domain.spi.IRolePersistencePort;
import org.pragma.usersfoodcourt.domain.spi.IUserPersistencePort;
import org.pragma.usersfoodcourt.domain.usecase.RoleUseCase;
import org.pragma.usersfoodcourt.domain.usecase.UserUseCase;
import org.pragma.usersfoodcourt.infrastructure.output.jpa.adapter.RoleJpaAdapter;
import org.pragma.usersfoodcourt.infrastructure.output.jpa.adapter.UserJpaAdapter;
import org.pragma.usersfoodcourt.infrastructure.output.jpa.repository.IRoleRepository;
import org.pragma.usersfoodcourt.infrastructure.output.jpa.repository.IUserRepository;
import org.pragma.usersfoodcourt.infrastructure.output.jpa.mapper.RoleEntityMapper;
import org.pragma.usersfoodcourt.infrastructure.output.jpa.mapper.UserEntityMapper;
import org.pragma.usersfoodcourt.application.handler.IEncryptHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IUserRepository iUserRepository;
    private final UserEntityMapper userEntityMapper;
    private final IRoleRepository iRoleRepository;
    private final RoleEntityMapper roleEntityMapper;
    private final IEncryptHandler iEncryptService;

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
