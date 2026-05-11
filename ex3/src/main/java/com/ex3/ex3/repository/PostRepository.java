package com.ex3.ex3.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ex3.ex3.entity.PostEntity;



public interface PostRepository
        extends JpaRepository<PostEntity, Long> {

    List<PostEntity> findByUserId(Long userId);
}