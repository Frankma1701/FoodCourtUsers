package org.pragma.foodcourtusers.domain.api;

import org.pragma.foodcourtusers.domain.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface IUserServicePort {

    User saveUser(User user);

    List<User> getAllUsers();

    User getUser(String documentId);

    void updateUser(User user);

    void deleteUser(String documentId);

}
