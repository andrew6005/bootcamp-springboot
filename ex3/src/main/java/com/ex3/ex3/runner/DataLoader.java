package com.ex3.ex3.runner;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.ex3.ex3.entity.UserEntity;
import com.ex3.ex3.repository.UserRepository;




@Component
public class DataLoader implements CommandLineRunner {

    private final RestTemplate restTemplate;
    private final UserRepository userRepository;

    public DataLoader(RestTemplate restTemplate,
                      UserRepository userRepository) {
        this.restTemplate = restTemplate;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        UserEntity[] users = restTemplate.getForObject(
                "https://jsonplaceholder.typicode.com/users",
                UserEntity[].class);

        userRepository.saveAll(Arrays.asList(users));

        System.out.println("Users loaded.");
    }
}