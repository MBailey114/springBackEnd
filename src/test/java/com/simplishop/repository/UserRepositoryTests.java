package com.simplishop.repository;

import com.simplishop.item.Item;
import com.simplishop.item.ItemRepository;
import com.simplishop.user.UserEntity;
import com.simplishop.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.core.userdetails.User;

import static org.hibernate.boot.model.process.spi.MetadataBuildingProcess.build;

@DataJpaTest
//USING A H2 DATABASE TO SIMULATE A REAL DATABASE
//CREATES A DATABASE IN MEMORY
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserRepositoryTests {

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
