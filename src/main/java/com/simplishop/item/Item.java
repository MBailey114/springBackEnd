package com.simplishop.item;
import jakarta.persistence.*;

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
    private Integer quatity;
    private Double price;

    public Item(Long id, String name, String image, String description, String category, Integer quatity, Double price) {
        Id = id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.category = category;
        this.quatity = quatity;
        this.price = price;
    }

    public Item(String name, String image, String description, String category, Integer quatity, Double price) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.category = category;
        this.quatity = quatity;
        this.price = price;
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

    public Integer getQuatity() {
        return quatity;
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

    public void setQuatity(Integer quatity) {
        this.quatity = quatity;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}