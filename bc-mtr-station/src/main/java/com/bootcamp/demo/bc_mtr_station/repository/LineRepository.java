package com.bootcamp.demo.bc_mtr_station.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bootcamp.demo.bc_mtr_station.entity.LineEntity;

public interface LineRepository extends JpaRepository<LineEntity, Long> {

}
