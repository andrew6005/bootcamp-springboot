package com.demojpa.demo_jpa_database.service;


import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demojpa.demo_jpa_database.entity.CartItemEntity;
import com.demojpa.demo_jpa_database.repository.CartItemRepository;

@Service
public class CartService {
  @Autowired
  private CartItemRepository cartItemRepository;

  public List<CartItemRepository> getAll() {
    return this.cartItemRepository.findAll();
  }

  public void remove(Long id) {
    this.cartItemRepository.deleteById(id);
  }

  public void removeAll() {
    this.cartItemRepository.deleteAll();
  }

  public CartItemEntity place(CartItemEntity cartItemEntity) {
    cartItemEntity.setDateTime(LocalDateTime.now());
    cartItemEntity.setSubtotal(cartItemEntity.getPrice() * cartItemEntity.getQuantity());
    return this.cartItemRepository.save(cartItemEntity);
  }
}