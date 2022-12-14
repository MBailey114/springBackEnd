package com.simplishop.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "shop/item")
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }
    @GetMapping
    public List<Item> getAllItems(){
        return itemService.getItems();
    }

    @GetMapping(path = "{itemId}")
    public String getOneItemById(@PathVariable("itemId") Long itemId){
        return itemService.getItemById(itemId);
    }

    @GetMapping(path = "{category}")
    public String getOneItemByCategory(@PathVariable("category") String category){
        return itemService.getItemByCategory(category);
    }
    @PostMapping
    public void addItem(@RequestBody Item item)
    {
        itemService.addNewItem(item);
    }
    @DeleteMapping(path = "{itemId}")
    public void deleteOneItem(@PathVariable("itemId") Long itemId)
    {
        itemService.deleteItem(itemId);
    }
    @PutMapping(path = "{itemId}")
    public void updateOneItem(@PathVariable("itemId") Long itemId,
                           @PathVariable(required = false) String name,
                           @PathVariable(required = false) String image,
                           @PathVariable(required = false) String description,
                           @PathVariable(required = false) String category,
                           @PathVariable(required = false) Integer quantity,
                           @PathVariable(required = false) Double price){
        itemService.editItem(itemId, name, image,description, category,quantity, price);
    }
}
