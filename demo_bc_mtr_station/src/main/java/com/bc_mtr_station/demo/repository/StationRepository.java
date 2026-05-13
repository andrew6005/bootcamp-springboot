package com.bc_mtr_station.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bc_mtr_station.demo.entity.StationEntity;

public interface StationRepository extends JpaRepository<StationEntity, Long> {
  List<StationEntity> findAllByLineCode(String lineCode);
  boolean existsByLineCodeAndStationCode(String lineCode, String stationCode);
  Optional<StationEntity> findByLineCodeAndStationCode(String lineCode, String stationCode);
}