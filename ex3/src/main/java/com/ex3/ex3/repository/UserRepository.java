package com.ex3.ex3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ex3.ex3.entity.UserEntity;



public interface UserRepository extends JpaRepository<UserEntity, Long> {
}