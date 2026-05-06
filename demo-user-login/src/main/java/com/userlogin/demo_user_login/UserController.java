package com.userlogin.demo_user_login;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {

        if (request.getUsername() == null || request.getUsername().trim().isEmpty()) {
            return "Username cannot be null or empty";
        }

        if (request.getPassword() == null || request.getPassword().trim().isEmpty()) {
            return "Password cannot be null or empty";
        }

        

        if (request.getPassword().length() < 8) {
            return "Password must be at least 8 characters";
        }

        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            return "Username already exists";
        }

        Userentity user = new Userentity(
                request.getUsername(),
                request.getPassword()
        );

        userRepository.save(user);

        return "Register success";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        if (request.getUsername() == null || request.getUsername().trim().isEmpty()) {
            return "Username cannot be null or empty";
        }

        if (request.getPassword() == null || request.getPassword().trim().isEmpty()) {
            return "Password cannot be null or empty";
        }

     

        if (request.getPassword().length() < 8) {
            return "Password must be at least 8 characters";
        }

        Userentity user = userRepository.findByUsername(request.getUsername())
                .orElse(null);

        if (user == null) {
            return "Invalid username";
        }

        if (user.getPassword().equals(request.getPassword())) {
            return "Login success";
        }

        return "Invalid password";
    }
}