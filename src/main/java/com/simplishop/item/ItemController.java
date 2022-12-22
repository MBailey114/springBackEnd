package com.simplishop.item;

import com.simplishop.item.exception.NoItemFoundException;
import com.simplishop.item.exception.UserNotFoundException;
import com.simplishop.user.UserEntity;
import com.simplishop.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@SpringBootApplication
@RestController
@RequestMapping(path = "shop/item")
public class ItemController {

    private final ItemService itemService;

    private UserRepository userRepo;
    private ItemRepository itemRepo;

    @Autowired
    public ItemController(ItemService itemService, ItemRepository itemRepository, UserRepository userRepository){
        this.itemService = itemService;
        this.itemRepo = itemRepository;
        this.userRepo = userRepository;
    }

    @GetMapping
    public List<Item> getItems(){
        return itemService.getItems();
    }

    @GetMapping(path = "{itemId}")
    public Optional<Item> getItemById(@PathVariable("itemId") Long itemId){
        return itemService.getItemById(itemId);
    }

    @GetMapping(path = "category/{category}")
    public List<Item> getItemByCategory(@PathVariable("category") String category){
        return itemService.getItemByCategory(category);
    }

    @GetMapping(path = "unassigned")
    public List<Item> getUnassignedItems() {
        return itemRepo.findByUserIdIsNull();
    }


    @GetMapping(path = "user/{userId}")
    public List<Item> getItemsByUser(@PathVariable("userId") Long userId){
        if(!userRepo.existsById(userId)){
            throw new UserNotFoundException("Not found User with id = " + userId);
        }

        List<Item> items = itemRepo.findByUserId(userId);
        return items;
    }

    @GetMapping(path = "userItems/{itemId}")
    public Long getUserIdByItem(@PathVariable("itemId") Long itemId) {
        Optional<Item> item = itemService.getItemById(itemId);
        UserEntity user = item.get().getUser();
        return user == null ? null : user.getId();
//        if (item.isPresent()) {
//            UserEntity user = item.get().getUser();
//            if (user != null) {
//                return user.getId();
//            } else {
//                throw new UserNotFoundException("Not found User for Item with id = " + itemId);
//            }
//        } else {
//            throw new NoItemFoundException("Not found Item with id = " + itemId);
//        }
    }

    @GetMapping(path = "search")
    public List<Item> searchItems(@RequestParam("q") String query) {
        List<Item> items = itemRepo.findByNameContainingIgnoreCase(query);
        if (items.isEmpty()) {
            items = itemRepo.findByDescriptionContainingIgnoreCase(query);
        }

        return items;
    }
    @PostMapping(path = "{userId}")
    public ResponseEntity<Item> addItem(@RequestBody Item item, @PathVariable(value = "userId") Long id)
    {
        itemService.addNewItem(item,id);
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }
    @DeleteMapping(path = "{itemId}")
    public void deleteItem(@PathVariable("itemId") Long itemId)
    {
        itemService.deleteItem(itemId);
    }

    record UpdateItem(Optional<String> name, Optional<String> image, Optional<String> description, Optional<String> category, Optional<Integer> quantity, Optional<Double> price){};

    @PutMapping(path = "{itemId}")
    public void updateItem(@RequestBody UpdateItem request, @PathVariable("itemId") Long itemId){
        itemService.editItem(itemId, request.name, request.image, request.description, request.category, request.quantity, request.price);
    }

    @PutMapping(path = "review/{itemId}")
    public void addToReviews(@PathVariable("itemId") Long itemId, @RequestBody Integer[] review) {
        itemService.addToReviews(itemId, review);
    }

    @DeleteMapping(path = "user/{userId}")
    public void deleteAllItemsByUser(@PathVariable("userId") Long userId) {
        // First, check if the user exists
        if (!userRepo.existsById(userId)) {
            throw new UserNotFoundException("Not found User with id = " + userId);
        }

        // Then, get all the items for the user
        List<Item> items = itemRepo.findByUserId(userId);

        // Finally, delete all the items
        itemRepo.deleteAll(items);
    }
}
