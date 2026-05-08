package com.bootcampspring.demo_call_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcampspring.demo_call_api.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}