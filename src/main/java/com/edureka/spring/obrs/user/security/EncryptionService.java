package com.edureka.spring.obrs.user.security;

public interface EncryptionService {
    String encryptString(String input);

    boolean checkPassword(String plainPassword, String encryptedPassword);
}
