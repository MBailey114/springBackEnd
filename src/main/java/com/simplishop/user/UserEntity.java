package com.simplishop.user;



import com.simplishop.item.Item;
import com.simplishop.security.Role;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
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

//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(name = "user_item", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"))
//    private List<Item> items = new ArrayList<>();

    // Add many-to-many relationship with Items

    // private List<Item> wishlist;
    // private List<Item> basket;


    public UserEntity(String firstName, String lastName, String password, String emailAddress, List<Integer> wishlist, List<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.emailAddress = emailAddress;
        this.wishlist = wishlist;
        this.roles = roles;
    }

    //    NO ID CONSTRUCTOR
    public UserEntity(String firstName, String lastName, String password, String emailAddress, List<Integer> wishlist) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.emailAddress = emailAddress;
        this.wishlist = wishlist;
    }


//    ID CONSTRUCTOR
public UserEntity(Long id, String firstName, String lastName, String password, String emailAddress, List<Integer> wishlist, List<Role> roles) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.password = password;
    this.emailAddress = emailAddress;
    this.wishlist = wishlist;
    this.roles = roles;
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
    public void addToWishlist(Integer itemId) {
        this.wishlist.add(itemId);
    }
    public void removeFromWishlist(Integer itemId)
    {
        this.wishlist.remove(itemId);
    }

//    public List<Item> getItems() {
//        return items;
//    }
//    public void setItems(List<Item> items) {
//        this.items = items;
//    }
}
