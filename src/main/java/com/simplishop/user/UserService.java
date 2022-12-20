package com.simplishop.user;

import com.simplishop.item.Item;
import com.simplishop.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    private static UserRepository userRepo;

    private static ItemRepository itemRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public static void updateUser(Long id, Optional<String> firstName, Optional<String> lastName, Optional<String> password, Optional<String> emailAddress) {
        Optional<UserEntity> optionalUser = userRepo.findById(id);

       if(optionalUser.isEmpty()) {
           return;
       }

       UserEntity user = optionalUser.get();

       user.setFirstName(firstName.isPresent() ? firstName.get() : user.getFirstName());
        user.setLastName(lastName.isPresent() ? lastName.get() : user.getLastName());
        user.setPassword(password.isPresent() ? password.get() : user.getPassword());
        user.setEmailAddress(emailAddress.isPresent() ? emailAddress.get() : user.getEmailAddress());

        userRepo.save(user);
    }

    public static void addToUserArray(Long id, Integer wishlist) {
        Optional<UserEntity> optionalUser = userRepo.findById(id);
        if(optionalUser.isEmpty()) {
            return;
        }
        UserEntity user = optionalUser.get();
        List<Integer> wishlistarray = user.getWishlist();
        for(int i = 0; i < wishlistarray.toArray().length; i++)
        {
            if(wishlistarray.toArray()[i] == wishlist)
            {
                user.removeFromWishlist(wishlist);
                userRepo.save(user);
                return;
            }
        }
        user.addToWishlist(wishlist);
        userRepo.save(user);
    }

    public static void deleteUser(Long id) {


        boolean exists = userRepo.existsById(id);
        if (!exists) {
            throw new IllegalStateException("user with id " + id + " does not exist");
        }
        userRepo.deleteById(id);
    }

    public static void addItemToUser(long userId, long itemId ){
        Optional<UserEntity> optionalUser = userRepo.findById(userId);
        Optional<Item> optionalItem = itemRepo.findItemById(itemId);
        UserEntity user = optionalUser.get();
        Item item = optionalItem.get();
//        user.getItems().add(item);
//        item.getUsers().add(user);
    }


    public List<UserEntity> getUsers() {
        return userRepo.findAll();
    }
    public UserEntity getCurrentUser(Authentication authentication) {
        Optional<UserEntity> currentUser = userRepo.findByEmailAddress(authentication.getName());
        if(currentUser.isEmpty()) {
            return null;
        }
        return currentUser.get();
    }

    public List<Integer> getUsersWishlist(Long id)
    {
        Optional<UserEntity> optionalUser = userRepo.findById(id);
        if(optionalUser.isEmpty()) {
            throw new IllegalStateException("user with id " + id + " does not exist");
        }
        UserEntity user = optionalUser.get();
        return user.getWishlist();
    }


    //    SAVING A USER
    public void addNewUser(UserEntity user) {
        userRepo.save(user);
    }




}
