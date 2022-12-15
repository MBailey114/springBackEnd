package com.simplishop.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    private static UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

//    **IN PROGRESS**
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

    public static void deleteUser(Long id) {


        boolean exists = userRepo.existsById(id);
        if (!exists) {
            throw new IllegalStateException("user with id " + id + " does not exist");
        }
        userRepo.deleteById(id);
    }


    public List<UserEntity> getUsers() {
        return userRepo.findAll();
    }

//    SAVING A USER
    public void addNewUser(UserEntity user) {
        userRepo.save(user);
    }




}
