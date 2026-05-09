package com.pcforum_ex.demo_pcforum_ex.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.pcforum_ex.demo_pcforum_ex.dto.UserCommentsDto;
import com.pcforum_ex.demo_pcforum_ex.dto.UserDto;
import com.pcforum_ex.demo_pcforum_ex.service.ForumService;
import java.util.List;

@RestController
public class ForumController {
    private final ForumService forumService;

    public ForumController(ForumService forumService) {
        this.forumService = forumService;
    }

    @GetMapping("/api/forum/users-posts-comments")
    public List<UserDto> getAllUsersPostsComments() {
        return forumService.getAllUsersWithPostsAndComments();
    }

    @GetMapping("/api/forum/comments")
    public UserCommentsDto getCommentsByUserId(@RequestParam Long userId) {
        return forumService.getCommentsByUserId(userId);
    }
}
