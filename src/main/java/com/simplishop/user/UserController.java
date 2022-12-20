package com.simplishop.user;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin
@SpringBootApplication
@RestController
@RequestMapping(path = "shop/user")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserEntity> getUser(){
        return userService.getUsers();
    }

    // GET /shop/user/me
    // Get the current user
    @GetMapping (path = "me")
    public UserEntity getCurrentUser(Authentication authentication){
        return userService.getCurrentUser(authentication);
    }

    @GetMapping(path = "wishlist/{id}")
    public List<Integer> getUserWishlist(@PathVariable("id") Long id){
        return userService.getUsersWishlist(id);
    }

    record NewUser(String firstName, String lastName, String password, String email){};
    record UpdateUserArray(Integer itemId){};

    record UpdateUser(Optional<String> firstName, Optional<String> lastName, Optional<String> password, Optional<String> email){};

    @PostMapping
    public void addUser(@RequestBody NewUser request){
        UserEntity user = new UserEntity();
        user.setFirstName(request.firstName());
        user.setLastName(request.lastName());
        user.setPassword(request.password());
        user.setEmailAddress(request.email());
        userService.addNewUser(user);
    }

    @PutMapping(path = "{id}")
    public void updateUser(@RequestBody UpdateUser request, @PathVariable("id") Long id) {
        UserService.updateUser(id, request.firstName, request.lastName, request.password, request.email);
    }

    @PutMapping(path = "wishlist/{id}")
    public void addUserArray(@RequestBody UpdateUserArray request, @PathVariable("id") Long id) {
        UserService.addToUserArray(id, request.itemId);
    }


    @DeleteMapping("{id}")
    public void deletingUser(@PathVariable("id") Long id) {
        UserService.deleteUser(id);
    }

    @PutMapping(path = "addItem/{itemId}/{userId}")
    public void addItemToUser(@PathVariable("itemId") long itemId, @PathVariable("userId") long userId){
        addItemToUser(userId,itemId);
    }

}