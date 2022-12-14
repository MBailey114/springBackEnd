package com.simplishop.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.List;

public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunnerUser(
            UserRepository userRepository) {
        return args -> {
            User user1 = new User(
                    "Joe",
                    "Bloggs",
                    "abc123",
                    "joebloggs@email.com"
            );
            User user2 = new User(
                    "John",
                    "Doe",
                    "abc123",
                    "johndoe@email.com"
            );
            userRepository.saveAll(
                    List.of(user1, user2));
        };
    }
}
