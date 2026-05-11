package com.ex3.ex3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ex3.ex3.entity.CommentEntity;


public interface CommentRepository
        extends JpaRepository<CommentEntity, Long> {

    List<CommentEntity> findByPostId(Long postId);
}