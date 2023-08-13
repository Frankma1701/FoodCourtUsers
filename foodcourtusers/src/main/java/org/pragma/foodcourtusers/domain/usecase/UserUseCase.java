package org.pragma.foodcourtusers.domain.usecase;

import org.pragma.foodcourtusers.domain.api.IUserServicePort;
import org.pragma.foodcourtusers.domain.model.User;
import org.pragma.foodcourtusers.domain.spi.IUserPersistencePort;

public class UserUseCase implements IUserServicePort{

    private IUserPersistencePort iUserPersistencePort;

    public UserUseCase (IUserPersistencePort iUserPersistencePort){
        this.iUserPersistencePort = iUserPersistencePort;
    }

    @Override
    public User saveUser (User user){
        return iUserPersistencePort.saveUser(user);
    }

    @Override
    public User  getUser (String documentId){
        return iUserPersistencePort.getUser(documentId);
    }


}
