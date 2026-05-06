package com.demojpa.demo_jpa_database.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


import com.demojpa.demo_jpa_database.service.CartService;

@Controller
@ResponseBody
public class CartController {
  @Autowired
  private CartService cartService;
  // place item
  @PostMapping(value = "/cartItem")
  public CartItemEntity create(@RequestBody CartItemEntity cartItemEntity) {
    return this.cartService.place(cartItemEntity);
  }

 
 
}