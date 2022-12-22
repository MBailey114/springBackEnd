package com.simplishop.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void ItemRepository_SaveAll_ReturnSavedItem() {

        //Arrange
        Item item = Item.builder()
                .name("Deluxe Garden Hose")
                .image("https://www.wheeliebinstoragedirect.co.uk/wp-content/uploads/2018/05/best-garden-hoses.jpg")
                .description("This high-quality garden hose is made from durable, weather-resistant materials and features a sturdy brass fittings.")
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
//        Item item = Item.builder()
//                .name("Deluxe Garden Hose")
//                .image("https://www.wheeliebinstoragedirect.co.uk/wp-content/uploads/2018/05/best-garden-hoses.jpg")
//                .description("This high-quality garden hose.")
//                .category("Garden")
//                .quantity(10)
//                .price(29.99)
//                .build();
//
//        //Arrange
//        Item item2 = Item.builder()
//                .name("Deluxe Garden Hose")
//                .image("https://www.wheeliebinstoragedirect.co.uk/wp-content/uploads/2018/05/best-garden-hoses.jpg")
//                .description("This high-quality garden hose.")
//                .category("Garden")
//                .quantity(10)
//                .price(29.99)
//                .build();
//
//        //Act
//        itemRepository.save(item);
//        itemRepository.save(item2);

        List<Item> itemList = itemRepository.findAll();

        //Assertions
        Assertions.assertThat(itemList).isNotNull();
        Assertions.assertThat(itemList.size()).isEqualTo(35);

    }

    @Test
    public void ItemRepository_FindById_ReturnsItem(){
        //Arrange
        Item item = Item.builder()
                .name("Deluxe Garden Hose")
                .image("https://www.wheeliebinstoragedirect.co.uk/wp-content/uploads/2018/05/best-garden-hoses.jpg")
                .description("This high-quality garden hose is made from durable, weather-resistant materials and features a sturdy brass fittings. ")
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

    @Test
    public void ItemRepository_FindByCategory_ReturnsItemNotNull(){
        //Arrange
        Item item = Item.builder()
                .name("Deluxe Garden Hose")
                .image("https://www.wheeliebinstoragedirect.co.uk/wp-content/uploads/2018/05/best-garden-hoses.jpg")
                .description("This high-quality garden hose is made from durable.")
                .category("Garden")
                .quantity(10)
                .price(29.99)
                .build();

        //Act
        itemRepository.save(item);

        Item itemList = itemRepository.findByCategory(item.getCategory()).get();

        //Assertions
        Assertions.assertThat(itemList).isNotNull();

    }

    //    THIS UPDATE IS FOR UPDATING ANY ATTRIBUTE FOR ITEM
//    ATTRIBUTES: name, image, description, category, quantity and price
    @Test
    public void ItemRepository_UpdateItem_ReturnsItemNotNull(){
        //Arrange
        Item item = Item.builder()
                .name("Deluxe Garden Hose")
                .image("https://www.wheeliebinstoragedirect.co.uk/wp-content/uploads/2018/05/best-garden-hoses.jpg")
                .description("This high-quality garden hose is made from durable.")
                .category("Garden")
                .quantity(10)
                .price(29.99)
                .build();

        itemRepository.save(item);

        Item itemSave = itemRepository.findById(item.getId()).get();
        itemSave.setCategory("Home");
        itemSave.setName("Regular Garden Hose");


        //Act
        Item updatedItem = itemRepository.save(itemSave);


        //Assertions
        Assertions.assertThat(updatedItem.getName()).isNotNull();
        Assertions.assertThat(updatedItem.getCategory()).isNotNull();

    }

    //   TESTING THAT WE CAN DELETE AN ITEM
    @Test
    public void ItemRepository_Delete_ReturnsItemIsEmpty(){
        //Arrange
        Item item = Item.builder()
                .name("Deluxe Garden Hose")
                .image("https://www.wheeliebinstoragedirect.co.uk/wp-content/uploads/2018/05/best-garden-hoses.jpg")
                .description("This high-quality garden hose is made from durable.")
                .category("Garden")
                .quantity(10)
                .price(29.99)
                .build();

        //Act
        itemRepository.save(item);

        itemRepository.deleteById(item.getId());
        Optional<Item> itemReturn = itemRepository.findById(item.getId());

        //Assertions
        Assertions.assertThat(itemReturn).isEmpty();

    }
}