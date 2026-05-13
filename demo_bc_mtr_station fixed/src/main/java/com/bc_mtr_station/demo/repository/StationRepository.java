package com.bc_mtr_station.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bc_mtr_station.demo.entity.StationEntity;

public interface StationRepository extends JpaRepository<StationEntity, String> {
    List<StationEntity> findByLineCode(String lineCode);
}
