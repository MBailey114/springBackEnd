package com.simplishop.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping(path = "shop/item")
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService){
        this.itemService = itemService;
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
    @PostMapping
    public void addItem(@RequestBody Item item)
    {
        itemService.addNewItem(item);
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
