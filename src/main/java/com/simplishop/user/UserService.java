package com.simplishop.user;

import jakarta.transaction.Transactional;
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
    public static void updateUser(Long id, String firstName, String lastName, String password, String emailAddress) {


    }

    public static void deleteUser(Long id) {


        boolean exists = userRepo.existsById(id);
        if (!exists) {
            throw new IllegalStateException("user with id " + id + " does not exist");
        }
        userRepo.deleteById(id);
    }


    public List<User> getUsers() {
        return userRepo.findAll();
    }

//    public void addNewUser(User user) {
//        Optional<User> userOptional = studentRepository
//                .findUserByEmail(user.getEmail());
//        if (userOptional.isPresent())
//        {
//            throw new IllegalStateException("email taken");
//        }
//        userRepo.save(user);
//    }




}
