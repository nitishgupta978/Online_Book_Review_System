package com.edureka.spring.obrs.user.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@DependsOn({"passwordEncoder"})
@Lazy
public class EncryptionServiceImpl implements EncryptionService {

    PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public String encryptString(String input) {
        return passwordEncoder.encode(input);
    }

    public boolean checkPassword(String plainPassword, String encryptedPassword) {
        return passwordEncoder.matches(plainPassword, encryptedPassword);
    }
}
