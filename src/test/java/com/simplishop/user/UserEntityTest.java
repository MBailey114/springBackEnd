package com.simplishop.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;

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

    @DataJpaTest
    //USING A H2 DATABASE TO SIMULATE A REAL DATABASE
    //CREATES A DATABASE IN MEMORY
    @AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
    public static class UserRepositoryTests {

        @Autowired
        private UserRepository userRepository;

    //    ATTRIBUTES FOR USER - emailAddress, firstName, lastName, password
        @Test
        public void  UserRepository_SaveAll_ReturnSavedUser() {

            //Arrange
            UserEntity user = UserEntity.builder()
                    .emailAddress("bob@gmail.com")
                    .firstName("Bob")
                    .lastName("Ross")
                    .password("artlover123")
                    .build();

            //Act
            UserEntity savedUser = userRepository.save(user);

            //Assert
    //        Checking that the item created and saved in the repository is actually being saved
            Assertions.assertThat(savedUser).isNotNull();
            Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
        }

        @Test
        public void  UserRepository_GetAll_ReturnMoreThanOneItem() {

            //Arrange
            UserEntity user = UserEntity.builder()
                    .emailAddress("bob@gmail.com")
                    .firstName("Bob")
                    .lastName("Ross")
                    .password("artlover123")
                    .build();

            //Act
            UserEntity savedUser = userRepository.save(user);

            //Assert
    //        Checking that the item created and saved in the repository is actually being saved
            Assertions.assertThat(savedUser).isNotNull();
            Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
        }

        @Test
        public void UserRepository_FindById_ReturnsUser(){
            //Arrange
            UserEntity user = UserEntity.builder()
                    .emailAddress("bob@gmail.com")
                    .firstName("Bob")
                    .lastName("Ross")
                    .password("artlover123")
                    .build();

            //Act
            userRepository.save(user);

            UserEntity userList = userRepository.findById(user.getId()).get();

            //Assertions
            Assertions.assertThat(userList).isNotNull();

        }




    }
}