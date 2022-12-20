package com.simplishop.item;

import com.simplishop.item.exception.UserNotFoundException;
import com.simplishop.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;
import com.simplishop.item.exception.NoItemFoundException;
@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private UserRepository userRepository;

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
    public void addNewItem(Item itemRequest,long userId){

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
}
