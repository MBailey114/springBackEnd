package com.simplishop.user;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    record NewUser(String firstName, String lastName, String password, String email){};
    @PostMapping
    public void addUser(@RequestBody NewUser request){
        User user = new User("","","","");
        user.setFirstName(request.firstName());
        user.setLastName(request.lastName());
        user.setPassword(request.password());
        user.setEmailAddress(request.email());

        userService.addNewUser(user);
    }

    @PutMapping(path = "{id}")
    public void updateStudent(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String emailAddress) {
        UserService.updateUser(id, firstName, lastName, password, emailAddress);
    }


    @DeleteMapping("{id}")
        public void deletingUser(@PathVariable("id") Long id) {
            UserService.deleteUser(id);
        }



}