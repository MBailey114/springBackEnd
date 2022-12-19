package com.simplishop.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunnerUser(
            UserRepository userRepository) {
        return args -> {
            User user1 = new User(
                    "Joe",
                    "Bloggs",
                    "abc123",
                    "joebloggs@email.com",
                    new ArrayList<Integer>()

            );
            User user2 = new User(
                    "John",
                    "Doe",
                    "abc123",
                    "johndoe@email.com",
                    new ArrayList<Integer>()

            );
            userRepository.saveAll(
                    List.of(user1, user2));
        };
    }
}
