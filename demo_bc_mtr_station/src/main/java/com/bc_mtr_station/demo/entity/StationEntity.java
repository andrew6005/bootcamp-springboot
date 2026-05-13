package com.bc_mtr_station.demo.entity;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Table(name = "line_stations")
public class StationEntity{
   @Id

  private String linecode;
  private String stationcode;

  public StationEntity(){

  }
  public String getlinecode(){
    return linecode;
  } 
  public String setlinecode(){
    return linecode;
  } 
  public String getstationcode(){
    return stationcode;
  }
  public String setstationcode(){
    return stationcode;
  }

}