package com.ex3.ex3.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ex3.ex3.dto.PostDto;
import com.ex3.ex3.entity.PostEntity;
import com.ex3.ex3.model.ApiResp;
import com.ex3.ex3.service.PostService;






@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ApiResp<List<PostDto>> getAllPosts() {
        return new ApiResp<>(
                "000000",
                "Success.",
                postService.getAllPosts()
        );
    }

    @GetMapping("/user/{userId}")
    public ApiResp<List<PostDto>> getPostsByUserId(
            @PathVariable Long userId) {

        return new ApiResp<>(
                "000000",
                "Success.",
                postService.getPostsByUserId(userId)
        );
    }

    @PostMapping("/user/{userId}")
    public ApiResp<PostDto> addPostByUserId(
            @PathVariable Long userId,
            @RequestBody PostEntity post) {

        return new ApiResp<>(
                "000000",
                "Post created.",
                postService.addPostByUserId(userId, post)
        );
    }

    @DeleteMapping("/{postId}")
    public ApiResp<String> deletePostById(
            @PathVariable Long postId) {

        postService.deletePostById(postId);

        return new ApiResp<>(
                "000000",
                "Post deleted.",
                null
        );
    }
}