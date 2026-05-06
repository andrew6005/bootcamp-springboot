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