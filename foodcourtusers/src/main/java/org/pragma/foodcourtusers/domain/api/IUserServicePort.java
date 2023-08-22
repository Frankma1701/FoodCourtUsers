package org.pragma.foodcourtusers.domain.api;

import org.pragma.foodcourtusers.domain.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface IUserServicePort {

    User saveUser(User user);

    User getUser(String documentId);

    User getUserById(Long id);
    
}
