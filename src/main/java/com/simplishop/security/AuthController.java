package com.simplishop.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.simplishop.security.AuthResponseDTO;
import com.simplishop.security.RegisterResponseDTO;
import com.simplishop.user.UserEntity;
import com.simplishop.user.UserRepository;
import com.simplishop.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private JWTGenerator jwtGenerator;

    private final UserService userService;

//    CONSTRUCTOR
    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, JWTGenerator jwtGenerator, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
        this.userService = userService;
    }

//    LOGIN ENDPOINT THAT WILL ALLOW A USER TO LOG IN AND STORE THEIR DETAILS
    @PostMapping("login")
    public ResponseEntity<AuthResponseDTO> login (@RequestBody LoginDTO loginDTO){
        System.out.println(0);
        System.out.println(loginDTO.getEmailAddress());
        System.out.println(loginDTO.getPassword());

        Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDTO.getEmailAddress(),
                        loginDTO.getPassword()));
        System.out.println(1);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println(2);
         String token = jwtGenerator.generateToken(authentication);
        System.out.println("TOken");
        System.out.println(token);
        return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
    }


//    SETTING UP JSON SO WE DON'T PASS ANY PASSWORDS IN URL STRING
    @PostMapping("register")
    public ResponseEntity<RegisterResponseDTO> register(@RequestBody RegisterDTO registerDTO){
        if(userRepository.existsByEmailAddress(registerDTO.getEmailAddress())){
            return new ResponseEntity<>( new RegisterResponseDTO("Email address already found"), HttpStatus.BAD_REQUEST);
        }

        UserEntity user = new UserEntity();
        user.setEmailAddress(registerDTO.getEmailAddress());
        user.setPassword(passwordEncoder.encode((registerDTO.getPassword())));
        user.setFirstName(registerDTO.getFirstName());
        user.setLastName(registerDTO.getLastName());
        user.setWishlist(new ArrayList<Integer>());
        user.setBasket(new ArrayList<Integer>());

//        DEFAULT ROLE = USER
         Role roles = roleRepository.findByName("USER").get();
         user.setRoles(Collections.singletonList(roles));

        userRepository.save(user);

        return new ResponseEntity<>(new RegisterResponseDTO("User registered successfully"), HttpStatus.OK);

    }

    @PostMapping("email")
    public ResponseEntity<EmailResponseDTO> register(@RequestBody EmailDTO emailDTO){
        if(userRepository.existsByEmailAddress(emailDTO.getEmailAddress())){
            return new ResponseEntity<>( new EmailResponseDTO(emailDTO.getEmailAddress(), true), HttpStatus.OK);
        }
        return new ResponseEntity<>(new EmailResponseDTO(emailDTO.getEmailAddress(), false), HttpStatus.OK);

    }

    @PostMapping("password")
    public ResponseEntity<EditPasswordResponseDTO> password(Authentication authentication, @RequestBody EditPasswordDTO editPasswordDTO) {
        System.out.println(editPasswordDTO);
        if(!authentication.isAuthenticated()){
            return new ResponseEntity<EditPasswordResponseDTO>(new EditPasswordResponseDTO("Bad token"), HttpStatus.UNAUTHORIZED);
        }
        // User is authenticated
        // Get current user
        UserEntity userEntity = userService.getCurrentUser(authentication);

        // Check password
        Boolean passwordMatch = passwordEncoder.matches(editPasswordDTO.getCurrentPassword(), userEntity.getPassword());
        if(!passwordMatch) {
            System.out.println("Incorrect password");
            return new ResponseEntity<EditPasswordResponseDTO>(new EditPasswordResponseDTO("Incorrect Password"), HttpStatus.UNAUTHORIZED);
        }

        userEntity.setPassword(passwordEncoder.encode(editPasswordDTO.getNewPassword()));
        userRepository.save(userEntity);
        return new ResponseEntity<EditPasswordResponseDTO>(new EditPasswordResponseDTO("Password changed"), HttpStatus.OK);
    }

}
