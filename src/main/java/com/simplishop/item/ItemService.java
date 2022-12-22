package com.simplishop.item;

import com.simplishop.item.exception.UserNotFoundException;
import com.simplishop.review.Review;
import com.simplishop.review.ReviewRepository;
import com.simplishop.user.UserEntity;
import com.simplishop.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;
import com.simplishop.item.exception.NoItemFoundException;
@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    private final ReviewRepository reviewRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository, UserRepository userRepository, ReviewRepository reviewRepository){
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
        this.reviewRepository = reviewRepository;
    }

    public List<Item> getItems()
    {
        return itemRepository.findAll();
    }
    public Optional<Item> getItemById(Long itemId)
    {
        return itemRepository.findById(itemId);
    }
    public List<Item> getItemByCategory(String category){
        List<Item> itemOptional = itemRepository.findAllByCategory(category);
        return itemOptional;
    }
    public void addNewItem(Item itemRequest,Long userId){

        Item item = userRepository.findById(userId).map(user -> {
            itemRequest.setUser(user);
            return itemRepository.save(itemRequest);
        }).orElseThrow(() -> new UserNotFoundException("Not found User with id = " + userId));

    }


    public void deleteItem(Long itemId){
        itemRepository.deleteById(itemId);
    }

    public void editItem(Long itemId, Optional<String> name, Optional<String> image, Optional<String> description, Optional<String> category, Optional<Integer> quantity, Optional<Double> price){
        Optional<Item> optionalItem = itemRepository.findItemById(itemId);
        if(optionalItem.isEmpty()) {
            throw new NoItemFoundException();
        }

        Item item = optionalItem.get();

        item.setName(name.isPresent() ? name.get() : item.getName());
        item.setImage(image.isPresent() ? image.get() : item.getImage());
        item.setDescription(description.isPresent() ? description.get() : item.getDescription());
        item.setCategory(category.isPresent() ? category.get() : item.getDescription());
        item.setQuantity(quantity.isPresent() ? quantity.get() : item.getQuantity());
        item.setPrice(price.isPresent() ? price.get() : item.getPrice());
        itemRepository.save(item);
    }

    public void addReview(Long itemId, Long userId, Review review) {
        // First, retrieve the item and the user making the review
        Item item = itemRepository.findById(itemId).orElse(null);
        UserEntity user = userRepository.findById(userId).orElse(null);

        // Check if the user has already made a review for this item
        if (item != null && user != null) {
            Review existingReview = reviewRepository.findByItemAndUser(item, user);
            if (existingReview == null) {
                // If the user has not made a review for this item, add the review
                review.setItem(item);
                review.setUser(user);
                reviewRepository.save(review);
            } else {
                // If the user has already made a review for this item, throw an exception
                throw new IllegalArgumentException("User has already made a review for this item");
            }
        } else {
            // If the item or user could not be found, throw an exception
            throw new IllegalArgumentException("Invalid item or user");
        }
    }

    public List<Review> getReviewsForItem(Long itemId) {
        Optional<Item> optionalItem = itemRepository.findItemById(itemId);
        Item item = optionalItem.get();
        return reviewRepository.findByItem(item);
    }
}
