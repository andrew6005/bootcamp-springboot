package com.demojpa.demo_jpa_database.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import com.demojpa.demo_jpa_database.entity.CartitemEntity;
import com.demojpa.demo_jpa_database.service.CartService;

@RestController
@Repository
public class CartController {
  @Autowired
  private CartService cartService;
  @PostMapping(value =  "/cartItem")
  public CartitemEntity create(@RequestBody CartitemEntity cartitemEntity){
    return this.cartService.place(CartitemEntity);
  }

 
 
}