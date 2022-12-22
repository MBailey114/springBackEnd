package com.simplishop.item;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ItemConfigTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void commandLineRunnerItem() {
        List<Item> items = itemRepository.findAll();
        Assertions.assertEquals(35, items.size());
        Assertions.assertEquals("Game Boy", items.get(0).getName());
    }
}