package com.simplishop.user;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping(path = "shop/user")
public class userController{

    private final UserRepository userRepo;

    public userController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }


    @GetMapping
    public List<User> getUser(){
        return userRepo.findAll();
    }


    record NewUser(String firstName, String lastName, String password, String email){};
    @PostMapping
    public void addUser(@RequestBody NewUser request){
        User user = new User();
        user.setFirstName(request.firstName());
        user.setLastName(request.lastName());
        user.setPassword(request.password());
        user.setEmailAddress(request.email());

        userRepo.save(user);
    }

    @DeleteMapping("{userId}")
    public void deleteUser(@PathVariable("userId") Integer id){
        userRepo.deleteById(id);
    }


}