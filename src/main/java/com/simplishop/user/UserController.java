package com.simplishop.user;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping(path = "shop/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public List<User> getUser(){
        return userService.getUsers();
    }

    @GetMapping(path = "wishlist/{id}")
    public List<Integer> getUserWishlist(@PathVariable("id") Long id){
        return userService.getUsersWishlist(id);
    }

    record NewUser(String firstName, String lastName, String password, String email){};

    record UpdateUser(Optional<String> firstName, Optional<String> lastName, Optional<String> password, Optional<String> email){};

    record UpdateUserArray(Integer itemId){};
    @PostMapping
    public void addUser(@RequestBody NewUser request){
        User user = new User("","","","", new ArrayList<Integer>());
        user.setFirstName(request.firstName());
        user.setLastName(request.lastName());
        user.setPassword(request.password());
        user.setEmailAddress(request.email());
        userService.addNewUser(user);
    }

    @PutMapping(path = "wishlist/{id}")
    public void addUserArray(@RequestBody UpdateUserArray request, @PathVariable("id") Long id) {
        UserService.addToUserArray(id, request.itemId);
    }

    @PutMapping(path = "{id}")
    public void updateUser(@RequestBody UpdateUser request, @PathVariable("id") Long id) {
        UserService.updateUser(id, request.firstName, request.lastName, request.password, request.email);
    }


    @DeleteMapping("{id}")
        public void deletingUser(@PathVariable("id") Long id) {
            UserService.deleteUser(id);
        }
}