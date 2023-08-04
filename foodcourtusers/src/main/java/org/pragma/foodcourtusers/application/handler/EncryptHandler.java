package org.pragma.foodcourtusers.application.handler;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;


@Service
public class EncryptHandler implements IEncryptHandler{


    @Override
    public String encryptPassword (String password){
        return BCrypt.hashpw(password,BCrypt.gensalt());
    }

    @Override
    public Boolean verifyPassword (String password, String hash){
        return false;
    }
}
