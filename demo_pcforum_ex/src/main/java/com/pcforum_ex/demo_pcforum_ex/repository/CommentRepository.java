package com.pcforum_ex.demo_pcforum_ex.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import com.pcforum_ex.demo_pcforum_ex.entity.CommentEntity;
import java.util.Arrays;
import java.util.List;

@Repository
public class CommentRepository {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private final RestTemplate restTemplate;

    public CommentRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<CommentEntity> findAll() {
        CommentEntity[] comments = restTemplate.getForObject(BASE_URL + "/comments", CommentEntity[].class);
        return comments == null ? List.of() : Arrays.asList(comments);
    }
}
