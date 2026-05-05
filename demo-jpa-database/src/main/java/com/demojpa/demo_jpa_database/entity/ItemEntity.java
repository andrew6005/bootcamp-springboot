package com.demojpa.demo_jpa_database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// create table ()

@Entity
@Table(name = "items")
@AllArgsConstructor
@Getter
public class ItemEntity {
  @Id // PK
  @GeneratedValue(strategy = GenerationType.IDENTITY) // serial, auto_increment
  private Long id; //
  private Double price;
  private Integer quantity;

  // FK
  @ManyToOne
  @JoinColumn(name = "order_id")
  @Setter
  private OrderEntity orderEntity;
}