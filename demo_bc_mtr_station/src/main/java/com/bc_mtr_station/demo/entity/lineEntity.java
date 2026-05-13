package com.bc_mtr_station.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mtr_lines")
public class lineEntity {
  @Id

  private String linecode;
  private String linename;
  public lineEntity(){

  }
  public String getlinecode(){
    return  linecode;
  }
  public void setlinecode(){
    return;
    
  }

    public String getlinename(){
    return  linename;
  }
    public void setlinename(){
    return;
    
  }



}
