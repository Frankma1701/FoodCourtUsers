package org.pragma.foodcourtusers.domain.api;

import org.pragma.foodcourtusers.domain.model.User;

public interface IUserServicePort {

    User saveUser(User user);

    User getUser(String documentId);

    User getUserById(Long id);
    
}
