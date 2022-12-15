package com.simplishop.user;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

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
    public List<UserEntity> getUser(){
        return userService.getUsers();
    }


    record NewUser(String firstName, String lastName, String password, String email){};

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


    @DeleteMapping("{id}")
        public void deletingUser(@PathVariable("id") Long id) {
            UserService.deleteUser(id);
        }



}