package com.demojpa.demo_jpa_database.controller;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class ItemController {

  @GetMapping("/items")
  public String getItems() {
    return "items";
  }
}