package org.pragma.usersfoodcourt.domain.api;

import org.pragma.usersfoodcourt.domain.model.User;

import java.util.List;

public interface IUserServicePort {

    void saveUser(User user);
    List<User> getAllUsers();

    User getUser(String documentId);

    void updateUser(User user);

    void deleteUser(String documentId);

}
