package com.simplishop.item;
import javax.persistence.AttributeConverter;
import com.simplishop.user.UserEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.simplishop.item.Review;
import org.hibernate.annotations.Type;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Item {
    @Id
    @SequenceGenerator(
            name="item_sequence",
            sequenceName = "item_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "item_sequence"
    )
    private Long Id;
    private String name;
    private String image;
    private String description;
    private String category;
    private Integer quantity;
    private Double price;


    @Convert(converter = ReviewListConverter.class)
    private List<Review> reviews;





    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private UserEntity user;


    public Item(Long id, String name, String image, String description, String category, Integer quantity, Double price) {
        Id = id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
        this.reviews = new ArrayList<>();
        }

    public Item(String name, String image, String description, String category, Integer quantity, Double price) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
        this.reviews = new ArrayList<>();
    }

    public Item() {
    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

}
