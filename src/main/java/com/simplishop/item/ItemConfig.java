package com.simplishop.item;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ItemConfig {
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
                    "Book",
                    "https://commons.wikimedia.org/wiki/File:Book.png",
                    "A book is a medium for recording information in the form of writing or images",
                    "Education",
                    1,
                    19.99
            );
            Item item4 = new Item(
                    "Phone",
                    "https://commons.wikimedia.org/wiki/File:Phone.png",
                    "A phone is a device used for communication and messaging.",
                    "Technology",
                    1,
                    199.99
            );
            Item item5 = new Item(
                    "Clothing",
                    "https://commons.wikimedia.org/wiki/File:Clothing.png",
                    "Clothing is a type of protective layer worn by humans for warmth or fashion",
                    "Fashion",
                    1,
                    29.99
            );
            Item item6 = new Item(
                    "Toy",
                    "https://commons.wikimedia.org/wiki/File:Toy.png",
                    "A toy is an object used for play or entertainment",
                    "Entertainment",
                    1,
                    9.99
            );
            itemRepository.saveAll(
                    List.of(item1, item2, item3, item4, item5, item6));
        };
    }
}
