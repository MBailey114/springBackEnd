package com.simplishop.user;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserEntityTest {

    @Test
    public void testGetterAndSetters() {
        UserEntity user = new UserEntity();
        user.setFirstName("Fred");
        user.setLastName("Bloggs");
        user.setPassword("abc123");
        user.setEmailAddress("fred@gmail.com");
        user.setWishlist(new ArrayList<>());
        user.setRoles(new ArrayList<>());

        assertEquals("Fred", user.getFirstName());
        assertEquals("Bloggs", user.getLastName());
        assertEquals("abc123", user.getPassword());
        assertEquals("fred@gmail.com", user.getEmailAddress());
        assertEquals(new ArrayList<>(), user.getWishlist());
        assertEquals(new ArrayList<>(), user.getRoles());
    }

    @Test
    public void testFullConstructor() {
        UserEntity user = new UserEntity( 1L, "Fred", "Bloggs", "abc123", "fred@gmail.com", new ArrayList<>(), new ArrayList<>() );

        assertEquals(1L, user.getId().longValue());
        assertEquals("Fred", user.getFirstName());
        assertEquals("Bloggs", user.getLastName());
        assertEquals("abc123", user.getPassword());
        assertEquals("fred@gmail.com", user.getEmailAddress());
        assertEquals(new ArrayList<>(), user.getWishlist());
        assertEquals(new ArrayList<>(), user.getRoles());
    }

    @Test
    public void testPartialConstructor() {
        UserEntity user = new UserEntity(  "Fred", "Bloggs", "abc123", "fred@gmail.com", new ArrayList<>() );

        assertEquals("Fred", user.getFirstName());
        assertEquals("Bloggs", user.getLastName());
        assertEquals("abc123", user.getPassword());
        assertEquals("fred@gmail.com", user.getEmailAddress());
        assertEquals(new ArrayList<>(), user.getWishlist());
    }

    @Test
    public void testDefaultConstructor() {
        UserEntity user = new UserEntity();

        assertEquals(null, user.getId());
        assertEquals(null, user.getFirstName());
        assertEquals(null, user.getLastName());
        assertEquals(null, user.getPassword());
        assertEquals(null, user.getEmailAddress());
        assertEquals(null, user.getWishlist());
        assertEquals(new ArrayList<>(), user.getRoles());
    }
}