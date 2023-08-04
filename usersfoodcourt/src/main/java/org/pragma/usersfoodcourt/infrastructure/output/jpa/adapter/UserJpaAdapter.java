package org.pragma.usersfoodcourt.infrastructure.output.jpa.adapter;

import lombok.RequiredArgsConstructor;
import org.pragma.usersfoodcourt.domain.model.User;
import org.pragma.usersfoodcourt.domain.spi.IUserPersistencePort;
import org.pragma.usersfoodcourt.infrastructure.exception.NoDataFoundException;
import org.pragma.usersfoodcourt.infrastructure.exception.UserAlreadyExistException;
import org.pragma.usersfoodcourt.infrastructure.exception.UserNotFoundException;
import org.pragma.usersfoodcourt.infrastructure.output.jpa.entity.UserEntity;
import org.pragma.usersfoodcourt.infrastructure.output.jpa.repository.IUserRepository;
import org.pragma.usersfoodcourt.infrastructure.output.jpa.mapper.UserEntityMapper;

import java.util.List;

@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {

    private final IUserRepository  iUserRepository;
    private final UserEntityMapper userEntityMapper;


    @Override
    public void saveUser(User user) {

        if(iUserRepository.findByDocumentId(user.getDocumentId()).isPresent()){
            throw new UserAlreadyExistException();
        }
        iUserRepository.save(userEntityMapper.toEntity(user));
    }

    @Override
    public List<User> getAllUsers() {
        List<UserEntity> userEntityList = iUserRepository.findAll();
        if(userEntityList.isEmpty()){
            throw new NoDataFoundException();
        }
        return userEntityMapper.toUserList(userEntityList);
    }

    @Override
    public User getUser(String documentId) {
        return userEntityMapper.toUser(iUserRepository.findByDocumentId(documentId).orElseThrow(UserNotFoundException::new));
    }

    @Override
    public void updateUser(User user) {
        iUserRepository.save(userEntityMapper.toEntity(user));
    }

    @Override
    public void deleteUser(String documentId) {
        iUserRepository.deleteByDocumentId(documentId);
    }
}
