package org.pragma.usersfoodcourt.application.handler;


public interface IEncryptHandler{

    String encryptPassword(String password);
    Boolean verifyPassword(String password, String hash);
}
