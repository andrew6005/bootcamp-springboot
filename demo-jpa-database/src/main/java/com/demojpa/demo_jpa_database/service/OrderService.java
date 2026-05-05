package com.demojpa.demo_jpa_database.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demojpa.demo_jpa_database.entity.ItemEntity;
import com.demojpa.demo_jpa_database.entity.OrderEntity;
import com.demojpa.demo_jpa_database.repository.ItemRepository;
import com.demojpa.demo_jpa_database.repository.OrderRepository;
import jakarta.transaction.Transactional;


@Service
public class OrderService {
 

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private ItemRepository itemRepository;


  @Transactional
  public OrderEntity order(List<ItemEntity> items) {

    Double orderAmount = items.stream()
        .mapToDouble(item -> item.getPrice() * item.getQuantity())
        .sum();

    OrderEntity orderEntity = OrderEntity.builder()
        .amount(orderAmount)
        .build();

    OrderEntity savedOrder = this.orderRepository.save(orderEntity);

    for (ItemEntity item : items) {
      item.setOrderEntity(savedOrder);
    }
    this.orderRepository.save(orderEntity);
    this.itemRepository.saveAll(items);

    return savedOrder; 
  }
}