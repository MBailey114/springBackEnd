package com.simplishop.security;


import com.simplishop.user.UserEntity;
import com.simplishop.user.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    private JWTGenerator jwtGenerator;

//    CONSTRUCTOR
    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, JWTGenerator jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
    }

//    LOGIN ENDPOINT THAT WILL ALLOW A USER TO LOG IN AND STORE THEIR DETAILS
    @PostMapping("login")
    public ResponseEntity<AuthResponseDTO> login (@RequestBody LoginDTO loginDTO){
        Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDTO.getEmail(),
                        loginDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
    }

    @PostMapping("register")
//    SETTING UP JSON SO WE DON'T PASS ANY PASSWORDS IN URL STRING
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDTO){
        System.out.println("Test user email is present");
        System.out.println(userRepository.existsByEmailAddress(registerDTO.getEmail()));
        System.out.println(registerDTO.getEmail());
        if(userRepository.existsByEmailAddress(registerDTO.getEmail())){
            return new ResponseEntity<>("Email is already in use", HttpStatus.BAD_REQUEST);
        }

        UserEntity user = new UserEntity();
        user.setEmailAddress(registerDTO.getEmail());
        user.setPassword(passwordEncoder.encode((registerDTO.getPassword())));

//        DEFAULT ROLE = USER
        System.out.println("Debug: ");

        System.out.println(roleRepository.findByName("USER").isPresent());
         Role roles = roleRepository.findByName("USER").get();
         user.setRoles(Collections.singletonList(roles));

        userRepository.save(user);

        return new ResponseEntity<>("User Registered Successfully", HttpStatus.OK);

    }

}
