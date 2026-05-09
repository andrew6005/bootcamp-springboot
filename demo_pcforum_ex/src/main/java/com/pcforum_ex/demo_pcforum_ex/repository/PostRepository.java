package com.pcforum_ex.demo_pcforum_ex.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import com.pcforum_ex.demo_pcforum_ex.entity.PostEntity;
import java.util.Arrays;
import java.util.List;

@Repository
public class PostRepository {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private final RestTemplate restTemplate;

    public PostRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<PostEntity> findAll() {
        PostEntity[] posts = restTemplate.getForObject(BASE_URL + "/posts", PostEntity[].class);
        return posts == null ? List.of() : Arrays.asList(posts);
    }
}
