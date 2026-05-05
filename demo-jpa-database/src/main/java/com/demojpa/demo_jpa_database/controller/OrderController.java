package com.demojpa.demo_jpa_database.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demojpa.demo_jpa_database.entity.ItemEntity;
import com.demojpa.demo_jpa_database.entity.OrderEntity;
import com.demojpa.demo_jpa_database.service.OrderService;

@RestController
public class OrderController {

  
  private final OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @PostMapping("/orders")
  public OrderEntity order(@RequestBody List<ItemEntity> items) {
    return orderService.order(items);
  }
}