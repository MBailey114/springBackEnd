package com.simplishop.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public List<Item> getItems()
    {
        return itemRepository.findAll()
    }
    public String getItemById()
    {
        return itemRepository.findById(itemId)
    }
}
