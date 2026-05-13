package com.bc_mtr_station.demo.dto;

public class LineDto {
  private String linecode;
  private String linename;

  public LineDto(){

  }

  public LineDto(String linecode , String linename){
    this.linecode = linecode;
    this.linename = linename;
  }

  public String getlinecode(){
    return linecode;

  }

  public void setlinname(String linecode){
    this.linename = linename;
  }

   public String getlinname(){
    return linename;

  }

  public void setlinecode(String linecode){
    this.linecode = linecode;
  }
  
}
