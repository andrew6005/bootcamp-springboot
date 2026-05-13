package com.bc_mtr_station.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bc_mtr_station.demo.entity.LineEntity;

public interface LineRepository extends JpaRepository<LineEntity, Long> {   
}
