package com.bootcamp.bcforum.repository;

import com.bootcamp.bcforum.entity.PostEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Integer> {

  List<PostEntity> findByUserId(Integer userId);
}
