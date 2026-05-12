package com.bootcamp.bcforum.repository;

import com.bootcamp.bcforum.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
