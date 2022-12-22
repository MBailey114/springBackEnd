package com.simplishop.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@SpringBootTest
@Configuration
public class UserConfigTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void commandLineRunnerUser() {
        List<UserEntity> users = userRepository.findAll();
        Assertions.assertEquals(2, users.size());
    }
}