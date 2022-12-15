package com.simplishop.security;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RoleConfig {
    @Bean
    CommandLineRunner commandLineRunnerUser(
            RoleRepository roleRepository) {
        return args -> {
            Role role1 = new Role("ADMIN");
            Role role2 = new Role("USER");
            roleRepository.saveAll(
                    List.of(role1, role2));
        };
    }
}
