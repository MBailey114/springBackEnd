package com.simplishop.item;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ItemControllerTest {

    @Autowired
    ItemRepository itemRepository;

    @Test
    void getItems() {
        List<Item> items = itemRepository.findAll();

        assertEquals(35, items.size());
    }

//    @Test
//    void getItemById() {
//    }
//
//    @Test
//    void getItemByCategory() {
//    }
//
//    @Test
//    void addItem() {
//    }
//
//    @Test
//    void deleteItem() {
//    }
//
//    @Test
//    void updateItem() {
//    }

    @ExtendWith(MockitoExtension.class)
    public static class ItemServiceTests {

        @Mock
        private ItemRepository itemRepository;

        @InjectMocks
        private ItemService itemService;

        @Test
        public void ItemService_CreateItem_ReturnsItemDTO() {

        }

    }
}