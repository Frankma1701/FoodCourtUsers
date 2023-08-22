package org.pragma.foodcourtusers.infrastructure.output.jpa.adapter;

import lombok.RequiredArgsConstructor;
import org.pragma.foodcourtusers.domain.model.User;
import org.pragma.foodcourtusers.domain.spi.IUserPersistencePort;
import org.pragma.foodcourtusers.infrastructure.exception.NoDataFoundException;
import org.pragma.foodcourtusers.infrastructure.exception.UserAlreadyExistException;
import org.pragma.foodcourtusers.infrastructure.exception.UserNotFoundException;
import org.pragma.foodcourtusers.infrastructure.output.jpa.entity.UserEntity;
import org.pragma.foodcourtusers.infrastructure.output.jpa.repository.IUserRepository;
import org.pragma.foodcourtusers.infrastructure.output.jpa.mapper.UserEntityMapper;

import java.util.List;

@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {

    private final IUserRepository  iUserRepository;
    private final UserEntityMapper userEntityMapper;


    @Override
    public User saveUser(User user) {
        if(iUserRepository.findByDocumentId(user.getDocumentId()).isPresent()){
            throw new UserAlreadyExistException();
        }
        UserEntity userEntity = iUserRepository.save(userEntityMapper.toEntity(user));
        return userEntityMapper.toUser(userEntity);
    }

    @Override
    public User getUser(String documentId) {
        return userEntityMapper.toUser(iUserRepository.findByDocumentId(documentId).orElseThrow(UserNotFoundException::new));
    }

    @Override
    public User getUserById (Long id){
        return userEntityMapper.toUser(iUserRepository.getReferenceById(id));
    }

}
