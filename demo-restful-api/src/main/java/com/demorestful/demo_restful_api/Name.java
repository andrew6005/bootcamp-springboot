package com.demorestful.demo_restful_api;

import lombok.Getter;
import lombok.Setter;


@Getter
public class Name {
  private String firstName;
  private String lastName;
  @Setter
  private Long id;
  private static long idCounter = 0;

  public Name() {}

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Name(String firstName,String lastName){
    this.firstName =firstName;
    this.lastName= lastName;
    this.id= ++idCounter;
  }
}