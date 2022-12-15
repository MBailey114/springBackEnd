package com.simplishop.user;



import jakarta.persistence.*;

import java.lang.reflect.Array;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    // Create an id in ascending order
    @Id
    @SequenceGenerator(
            name = "user_id_sequence",
            sequenceName = "user_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_id_sequence"
    )
    private Long id;

    private String firstName;
    private String lastName;

    // Change this in the future
    private String password;

    private String emailAddress;

    // Add many-to-many relationship with Items

    // private List<Item> wishlist;
    // private List<Item> basket;


//    NO ID CONSTRUCTOR
    public User(String firstName, String lastName, String password, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.emailAddress = emailAddress;
    }

//    NOTHING CONSTRUCTOR
    public User() {

    }

//    ID CONSTRUCTOR
public User( Long id, String firstName, String lastName, String password, String emailAddress) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.password = password;
    this.emailAddress = emailAddress;
}





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
