package com.ex3.ex3.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ex3.ex3.dto.CommentDto;
import com.ex3.ex3.entity.CommentEntity;
import com.ex3.ex3.model.ApiResp;
import com.ex3.ex3.service.CommentService;



@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public ApiResp<List<CommentDto>> getAllComments() {
        return new ApiResp<>(
                "000000",
                "Success.",
                commentService.getAllComments()
        );
    }

    @GetMapping("/post")
    public ApiResp<List<CommentDto>> getCommentsByPostId(
            @RequestParam Long id) {

        return new ApiResp<>(
                "000000",
                "Success.",
                commentService.getCommentsByPostId(id)
        );
    }

    @PostMapping("/post")
    public ApiResp<CommentDto> addCommentByPostId(
            @RequestParam Long id,
            @RequestBody CommentEntity comment) {

        return new ApiResp<>(
                "000000",
                "Comment created.",
                commentService.addCommentByPostId(id, comment)
        );
    }

    @PatchMapping("/{commentId}/body")
    public ApiResp<CommentDto> patchCommentBody(
            @PathVariable Long commentId,
            @RequestParam String body) {

        return new ApiResp<>(
                "000000",
                "Comment updated.",
                commentService.patchCommentBody(commentId, body)
        );
    }
}