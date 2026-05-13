package com.bc_mtr_station.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bc_mtr_station.demo.entity.lineEntity;

public interface LineRepository  extends JpaRepository<lineEntity,Long>{

   
}
