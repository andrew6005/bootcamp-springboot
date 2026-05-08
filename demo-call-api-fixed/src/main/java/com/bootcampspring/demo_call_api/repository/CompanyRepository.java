package com.bootcampspring.demo_call_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bootcampspring.demo_call_api.entity.CompanyEntity;


public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {

}