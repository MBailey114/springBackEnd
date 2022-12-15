package com.simplishop.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunnerUser(
            UserRepository userRepository) {
        return args -> {
            UserEntity user1 = new UserEntity(
                    "Joe",
                    "Bloggs",
                    "abc123",
                    "joebloggs@email.com"
            );
            UserEntity user2 = new UserEntity(
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
