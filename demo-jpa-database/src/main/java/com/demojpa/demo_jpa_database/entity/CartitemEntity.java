package com.demojpa.demo_jpa_database.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "cart_items")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CartitemEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // serial, auto_increment
  private Long id;
  @Column(nullable = false)
  private Double price;
  @Column(nullable = false)
  private Integer quantity;
  @Column(nullable = false)
  @Setter
  private Double subtotal;
  @Column(nullable = false)
  @Setter
  private LocalDateTime dateTime;
}