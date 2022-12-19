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
                    "Technology",
                    5,
                    20.00
            );
            Item item2 = new Item(
                    "scooter",
                    "https://www.laptopsdirect.co.uk/Images/E-SC10-V1_1_Supersize.jpg?v=61",
                    "electric scooter",
                    "Toys",
                    5,
                    12.99
            );
            Item item3 = new Item(
                    "Book",
                    "https://shadycharacters.co.uk/wp/wp-content/uploads/2016/12/Book_IMG_1754-1-e1481474081467.jpg",
                    "A book is a medium for recording information in the form of writing or images",
                    "Education",
                    1,
                    19.99
            );
            Item item4 = new Item(
                    "Phone",
                    "https://www.three.co.uk/cs/Satellite?blobkey=id&blobwhere=1401331509853&blobcol=urldata&blobtable=MungoBlobs",
                    "A phone is a device used for communication and messaging.",
                    "Technology",
                    1,
                    199.99
            );
            Item item5 = new Item(
                    "Clothing",
                    "https://expertreviews.b-cdn.net/sites/expertreviews/files/styles/er_main_wide/public/2019/08/best_online_clothes_shops.jpg?itok=L8unGI0O",
                    "Clothing is a type of protective layer worn by humans for warmth or fashion",
                    "Fashion",
                    1,
                    29.99
            );
            Item item6 = new Item(
                    "Toy",
                    "https://www.ikea.com/gb/en/images/products/blavingad-soft-toy-blue-whale__1107939_pe869237_s5.jpg?f=s",
                    "A toy is an object used for play or entertainment",
                    "Entertainment",
                    1,
                    9.99
            );
            Item item7 = new Item(
                    "Laptop",
                    "https://m.media-amazon.com/images/I/711jgF2LHPL._AC_SY450_.jpg",
                    "A high-performance laptop with a sleek design and powerful processor",
                    "Technology",
                    10,
                    1000.00
            );
            Item item8 = new Item(
                    "Bookshelf",
                    "https://www.therange.co.uk/_m3/8/2/1465382547_829.jpg",
                    "A sturdy bookshelf made of solid wood",
                    "Home",
                    5,
                    150.00
            );
            Item item9 = new Item(
                    "Portable Speaker",
                    "https://m.media-amazon.com/images/I/810dSwE0MoL._AC_SL1500_.jpg",
                    "A portable Bluetooth speaker with excellent sound quality",
                    "Technology",
                    15,
                    50.00
            );
            Item item10 = new Item(
                    "Painting",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Mona_Lisa%2C_by_Leonardo_da_Vinci%2C_from_C2RMF_retouched.jpg/1200px-Mona_Lisa%2C_by_Leonardo_da_Vinci%2C_from_C2RMF_retouched.jpg",
                    "A beautiful landscape painting by a local artist",
                    "Home",
                    3,
                    200.00
            );
            Item item11 = new Item(
                    "Sneakers",
                    "https://www.chloe.com/product_image/11596937jh/f/w1080.jpg",
                    "A pair of comfortable and stylish sneakers",
                    "Fashion",
                    20,
                    75.00
            );
            Item item12 = new Item(
                    "Office Chair",
                    "https://www.ikea.com/gb/en/images/products/flintan-office-chair-with-armrests-black__1007241_pe825960_s5.jpg",
                    "An ergonomic office chair with adjustable lumbar support",
                    "Home",
                    10,
                    150.00
            );
            itemRepository.saveAll(
                    List.of(item1, item2, item3, item4, item5, item6,item7, item8, item9, item10, item11, item12));
        };
    }
}
