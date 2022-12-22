package com.simplishop.item;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemTest {

    @Test
    public void testGettersAndSetters() {
        Item item = new Item();
        item.setName("Test Item");
        item.setImage("test.jpg");
        item.setDescription("This is a test item.");
        item.setCategory("Test Category");
        item.setQuantity(5);
        item.setPrice(10.50);

        assertEquals("Test Item", item.getName());
        assertEquals("test.jpg", item.getImage());
        assertEquals("This is a test item.", item.getDescription());
        assertEquals("Test Category", item.getCategory());
        assertEquals(5, item.getQuantity().intValue());
        assertEquals(10.50, item.getPrice(), 0.001);
    }

    @Test
    public void testFullConstructor() {
        Item item = new Item(1L, "Test Item", "test.jpg", "This is a test item.", "Test Category", 5, 10.50);

        assertEquals(1L, item.getId().longValue());
        assertEquals("Test Item", item.getName());
        assertEquals("test.jpg", item.getImage());
        assertEquals("This is a test item.", item.getDescription());
        assertEquals("Test Category", item.getCategory());
        assertEquals(5, item.getQuantity().intValue());
        assertEquals(10.50, item.getPrice(), 0.001);
    }

    @Test
    public void testPartialConstructor() {
        Item item = new Item("Test Item", "test.jpg", "This is a test item.", "Test Category", 5, 10.50);

        assertEquals("Test Item", item.getName());
        assertEquals("test.jpg", item.getImage());
        assertEquals("This is a test item.", item.getDescription());
        assertEquals("Test Category", item.getCategory());
        assertEquals(5, item.getQuantity().intValue());
        assertEquals(10.50, item.getPrice(), 0.001);
    }

    @Test
    public void testDefaultConstructor() {
        Item item = new Item();

        assertEquals(null, item.getId());
        assertEquals(null, item.getName());
        assertEquals(null, item.getImage());
        assertEquals(null, item.getDescription());
        assertEquals(null, item.getCategory());
        assertEquals(null, item.getQuantity());
        assertEquals(null, item.getPrice());
    }
}