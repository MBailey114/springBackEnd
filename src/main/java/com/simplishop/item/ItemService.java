package com.simplishop.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;
@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
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
    public void addNewItem(Item item){
        itemRepository.save(item);
    }

    public void deleteItem(Long itemId){
        itemRepository.deleteById(itemId);
    }

    public void editItem(Long itemId,String name,String image,String description,String category,Integer quantity,Double price){
        Item item = itemRepository.findById(itemId).orElseThrow(() -> new IllegalStateException(
                "Item with id " + itemId + " does not exist"));
        if(name != null && name.length() > 0)
        {
            item.setName(name);
        }
        if(image != null && image.length() > 0)
        {
            item.setImage(image);
        }
        if(description != null && description.length() > 0)
        {
            item.setDescription(description);
        }
        if(category != null && category.length() > 0)
        {
            item.setCategory(category);
        }
        if(quantity != null && quantity >= 0)
        {
            item.setQuantity(quantity);
        }
        if(price != null && price >= 0)
        {
            item.setPrice(price);
        }
    }
}
