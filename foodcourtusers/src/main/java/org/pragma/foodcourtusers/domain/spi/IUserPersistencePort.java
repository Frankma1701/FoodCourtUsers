package org.pragma.foodcourtusers.domain.spi;

import org.pragma.foodcourtusers.domain.model.User;

import java.util.List;

public interface IUserPersistencePort {
    User saveUser(User user);
    List<User> getAllUsers();

    User getUser(String documentId);

    void updateUser(User user);

    void deleteUser(String documentId);
}
