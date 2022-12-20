package com.simplishop.item;

import com.simplishop.item.exception.UserNotFoundException;
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

    @GetMapping(path = "Author/{userId}")
    public List<Item> getItemsByUser(@PathVariable("userId") Long userId){
        if(!userRepo.existsById(userId)){
            throw new UserNotFoundException("Not found User with id = " + userId);
        }

        List<Item> items = itemRepo.findByUserId(userId);
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
}
