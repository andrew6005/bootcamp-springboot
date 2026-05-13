package com.bc_mtr_station.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bc_mtr_station.demo.entity.LineEntity;

public interface LineRepository extends JpaRepository<LineEntity, Long> {
  Optional<LineEntity> findByLineCode(String lineCode);
  boolean existsByLineCode(String lineCode);
}