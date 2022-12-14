package com.simplishop.item;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class itemConfig {
    @Bean
    CommandLineRunner commandLineRunnerItem(
            ItemRepository itemRepository) {
        return args -> {
            Item item1 = new Item(
                    "game boy",
                    "https://upload.wikimedia.org/wikipedia/commons/f/f4/Game-Boy-FL.jpg",
                    "1990s games console from Nintendo",
                    "technology",
                    5,
                    20.00
            );
            Item item2 = new Item(
                    "scooter",
                    "https://www.laptopsdirect.co.uk/Images/E-SC10-V1_1_Supersize.jpg?v=61",
                    "electric scooter",
                    "toys",
                    5,
                    12.99
            );
            Item item3 = new Item(
                    "",
                    "",
                    "",
                    "",

                    )
            itemRepository.saveAll(
                    List.of(item1, item2, item3));
        };
    }
}
