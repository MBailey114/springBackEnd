package com.simplishop.repository;

import com.simplishop.item.Item;
import com.simplishop.item.ItemRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
//USING A H2 DATABASE TO SIMULATE A REAL DATABASE
//CREATES A DATABASE IN MEMORY
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ItemRepositoryTests {
    @Autowired
    private ItemRepository itemRepository;

//    public ItemRepositoryTests(ItemRepository itemRepository) {
//        this.itemRepository = itemRepository;
//    }

    @Test
    public void ItemRepository_SaveAll_ReturnSavedItem() {

        //Arrange
        Item item = Item.builder()
                .name("Deluxe Garden Hose")
                .image("https://www.wheeliebinstoragedirect.co.uk/wp-content/uploads/2018/05/best-garden-hoses.jpg")
                .description("This high-quality garden hose is made from durable, weather-resistant materials and features a sturdy brass fittings. The flexible design allows for easy maneuvering and storage, and the 50-foot length is perfect for reaching all areas of your garden. Whether you're watering plants, washing your car, or cleaning your deck, this hose is sure to be a reliable and efficient tool.")
                .category("Garden")
                .quantity(10)
                .price(29.99)
                .build();

        //Act
        Item savedItem = itemRepository.save(item);

        //Assert
//        Checking that the item created and saved in the repository is actually being saved
        Assertions.assertThat(savedItem).isNotNull();
        Assertions.assertThat(savedItem.getId()).isGreaterThan(0);
    }

    @Test
    public void ItemRepository_GetAll_ReturnMoreThanOneItem(){
        //Arrange
        Item item = Item.builder()
                .name("Deluxe Garden Hose")
                .image("https://www.wheeliebinstoragedirect.co.uk/wp-content/uploads/2018/05/best-garden-hoses.jpg")
                .description("This high-quality garden hose is made from durable, weather-resistant materials and features a sturdy brass fittings. The flexible design allows for easy maneuvering and storage, and the 50-foot length is perfect for reaching all areas of your garden. Whether you're watering plants, washing your car, or cleaning your deck, this hose is sure to be a reliable and efficient tool.")
                .category("Garden")
                .quantity(10)
                .price(29.99)
                .build();

        //Arrange
        Item item2 = Item.builder()
                .name("Deluxe Garden Hose")
                .image("https://www.wheeliebinstoragedirect.co.uk/wp-content/uploads/2018/05/best-garden-hoses.jpg")
                .description("This high-quality garden hose is made from durable, weather-resistant materials and features a sturdy brass fittings. The flexible design allows for easy maneuvering and storage, and the 50-foot length is perfect for reaching all areas of your garden. Whether you're watering plants, washing your car, or cleaning your deck, this hose is sure to be a reliable and efficient tool.")
                .category("Garden")
                .quantity(10)
                .price(29.99)
                .build();

        //Act
        itemRepository.save(item);
        itemRepository.save(item2);

        List<Item> itemList = itemRepository.findAll();

        //Assertions
        Assertions.assertThat(itemList).isNotNull();
        Assertions.assertThat(itemList.size()).isEqualTo(2);

    }

    @Test
    public void ItemRepository_FindById_ReturnsItem(){
        //Arrange
        Item item = Item.builder()
                .name("Deluxe Garden Hose")
                .image("https://www.wheeliebinstoragedirect.co.uk/wp-content/uploads/2018/05/best-garden-hoses.jpg")
                .description("This high-quality garden hose is made from durable, weather-resistant materials and features a sturdy brass fittings. The flexible design allows for easy maneuvering and storage, and the 50-foot length is perfect for reaching all areas of your garden. Whether you're watering plants, washing your car, or cleaning your deck, this hose is sure to be a reliable and efficient tool.")
                .category("Garden")
                .quantity(10)
                .price(29.99)
                .build();

        //Act
        itemRepository.save(item);

       Item itemList = itemRepository.findById(item.getId()).get();

        //Assertions
        Assertions.assertThat(itemList).isNotNull();

    }
}
