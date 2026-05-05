package com.demojpa.demo_jpa_database.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.demojpa.demo_jpa_database.entity.OrderEntity;


// Long -> PK
// OrderEntity -> Table

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
  // Hibernate Framework -> Create a java class, which implement this interface
    // insert (Java Method: save Entity)
    // update (Java Method: save Entity)
    // delete (Java Method: deleteByXXX)
    // select (Java Method: findByXXX)
  // Dependency (pom) -> Postgresql/ Oracle/ MySQL
}