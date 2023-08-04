package org.pragma.foodcourtusers.domain.usecase;

import org.pragma.foodcourtusers.domain.api.IUserServicePort;
import org.pragma.foodcourtusers.domain.model.User;
import org.pragma.foodcourtusers.domain.spi.IUserPersistencePort;

import java.util.List;
// Conection with the infrastructure

public class UserUseCase implements IUserServicePort {

    private IUserPersistencePort iUserPersistencePort;

    public UserUseCase(IUserPersistencePort iUserPersistencePort) {
        this.iUserPersistencePort = iUserPersistencePort;
    }
    @Override
    public User saveUser(User user) {
        return iUserPersistencePort.saveUser(user);
    }
    @Override
    public List<User> getAllUsers() {
        return iUserPersistencePort.getAllUsers();
    }
    @Override
    public User getUser(String documentId) {
        return iUserPersistencePort.getUser(documentId);
    }
    @Override
    public void updateUser(User user) {
        iUserPersistencePort.updateUser(user);
    }
    @Override
    public void deleteUser(String documentId) {
        iUserPersistencePort.deleteUser(documentId);
    }
}
