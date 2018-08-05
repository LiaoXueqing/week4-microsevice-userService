package com.thoughtworks.training.xueqing.todoservice;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.Assert.assertTrue;

public class PasswordTest {
    @Test
    public void shouldEncryPassword(){
        BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode("password");
        boolean matches = encoder
                .matches("password",encodedPassword);
        assertTrue(matches);
        
    }
}
