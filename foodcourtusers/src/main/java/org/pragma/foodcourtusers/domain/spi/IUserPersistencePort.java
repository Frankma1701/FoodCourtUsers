package org.pragma.foodcourtusers.domain.spi;

import org.pragma.foodcourtusers.domain.model.User;

public interface IUserPersistencePort {
    User saveUser(User user);

    User getUser(String documentId);

    User getUserById(Long id);


}
