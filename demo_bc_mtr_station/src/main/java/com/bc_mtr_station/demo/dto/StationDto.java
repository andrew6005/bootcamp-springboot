package com.bc_mtr_station.demo.dto;

public class StationDto {
  private String linecode;
  private String stationcode;

  public StationDto(){

  }
  public StationDto(String linecode, String stationcode){
    this.linecode =linecode;
    this.stationcode = stationcode;
  }
  public String getlinecode(){
    return linecode;
  }
  public void setlinecode(String linecode){
    this.linecode= linecode;
  }
   public String getstationcode(){
    return stationcode;
  }
    public void setstationcode(String stationcode){
    this.stationcode= stationcode;
  }


}
