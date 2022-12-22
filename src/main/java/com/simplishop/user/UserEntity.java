package com.simplishop.user;



import com.simplishop.security.Role;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Table(name = "users")
@Data
//@NoArgsConstructor
public class UserEntity {

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
    private List<Integer> wishlist;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles = new ArrayList<>();

    private List<Integer> basket;




    public UserEntity(String firstName, String lastName, String password, String emailAddress, List<Integer> wishlist, List<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.emailAddress = emailAddress;
        this.wishlist = wishlist;
        this.roles = roles;
    }

//    NO ID CONSTRUCTOR
    public UserEntity(String firstName, String lastName, String password, String emailAddress, List<Integer> wishlist, List<Integer> basket) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.emailAddress = emailAddress;
        this.wishlist = wishlist;
        this.basket = basket;

        this.wishlist.add(0);
        this.basket.add(0);
    }


//    ID CONSTRUCTOR

public UserEntity(Long id, String firstName, String lastName, String password, String emailAddress, List<Integer> wishlist, List<Integer> basket) {

    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.password = password;
    this.emailAddress = emailAddress;
    this.wishlist = wishlist;

    this.basket = basket;

    this.wishlist.add(0);
    this.basket.add(0);

}

    public UserEntity() {
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

    public List<Role> getRoles() {
        return roles;
    }

    public List<Integer> getWishlist() {
        return wishlist;
    }

    public void setWishlist() {
        this.wishlist = wishlist;
    }

    public void addToWishlist(Integer itemId) {
        this.wishlist.add(itemId);
    }
    public void removeFromWishlist(Integer itemId)
    {
        this.wishlist.remove(itemId);
    }


    public void addToBasket(Integer itemId) {this.basket.add(itemId);}
    public void removeFromBasket(Integer itemId) {this.basket.remove(itemId);}
    public void resetBasket(){ this.basket = new ArrayList<Integer>();}

    public List<Integer> getBasket() {
        return basket;
    }

    public void setBasket(List<Integer> basket) {
        this.basket = basket;
    }

}
