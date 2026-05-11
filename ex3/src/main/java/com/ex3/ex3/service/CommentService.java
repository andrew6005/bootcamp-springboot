package com.ex3.ex3.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.ex3.ex3.dto.CommentDto;
import com.ex3.ex3.entity.CommentEntity;
import com.ex3.ex3.repository.CommentRepository;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    // GET all comments
    public List<CommentDto> getAllComments() {

        return commentRepository.findAll()
                .stream()
                .map(this::entityToDto)
                .toList();
    }

    // GET comments by post id
    public List<CommentDto> getCommentsByPostId(Long postId) {

        return commentRepository.findByPostId(postId)
                .stream()
                .map(this::entityToDto)
                .toList();
    }

    // POST comment
    public CommentDto addCommentByPostId(
            Long postId,
            CommentEntity comment) {

        comment.setPostId(postId);

        CommentEntity savedComment =
                commentRepository.save(comment);

        return entityToDto(savedComment);
    }

    // PATCH comment body
    public CommentDto patchCommentBody(
            Long commentId,
            String body) {

        CommentEntity comment =
                commentRepository.findById(commentId)
                .orElseThrow(() ->
                        new RuntimeException("Comment not found"));

        comment.setBody(body);

        CommentEntity updatedComment =
                commentRepository.save(comment);

        return entityToDto(updatedComment);
    }

    // Entity -> DTO
    private CommentDto entityToDto(
            CommentEntity entity) {

        return new CommentDto(
                entity.getId(),
                entity.getPostId(),
                entity.getName(),
                entity.getEmail(),
                entity.getBody()
        );
    }
}