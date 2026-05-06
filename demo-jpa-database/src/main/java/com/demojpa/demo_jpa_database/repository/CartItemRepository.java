package com.demojpa.demo_jpa_database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.demojpa.demo_jpa_database.entity.CartItemEntity;

@Repository
public interface CartItemRepository
    extends JpaRepository<CartItemRepository, Long> {

    CartItemEntity save(CartItemEntity cartItemEntity);

}
