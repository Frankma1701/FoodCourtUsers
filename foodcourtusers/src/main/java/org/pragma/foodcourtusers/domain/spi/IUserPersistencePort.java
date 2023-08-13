package org.pragma.foodcourtusers.domain.spi;

import org.pragma.foodcourtusers.domain.model.User;

import java.util.List;

public interface IUserPersistencePort {
    User saveUser(User user);

    User getUser(String documentId);

}
