package com.pcforum_ex.demo_pcforum_ex.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import com.pcforum_ex.demo_pcforum_ex.entity.UserEntity;
import java.util.Arrays;
import java.util.List;

@Repository
public class UserRepository {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private final RestTemplate restTemplate;

    public UserRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<UserEntity> findAll() {
        UserEntity[] users = restTemplate.getForObject(BASE_URL + "/users", UserEntity[].class);
        return users == null ? List.of() : Arrays.asList(users);
    }
}
