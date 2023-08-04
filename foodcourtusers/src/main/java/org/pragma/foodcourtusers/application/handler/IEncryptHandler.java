package org.pragma.foodcourtusers.application.handler;


public interface IEncryptHandler{

    String encryptPassword(String password);
    Boolean verifyPassword(String password, String hash);
}
