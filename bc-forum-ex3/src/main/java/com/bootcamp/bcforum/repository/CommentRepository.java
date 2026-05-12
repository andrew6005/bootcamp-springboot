package com.bootcamp.bcforum.repository;

import com.bootcamp.bcforum.entity.CommentEntity;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {

  List<CommentEntity> findByPostId(Integer postId);

  List<CommentEntity> findByPostIdIn(Collection<Integer> postIds);
}
