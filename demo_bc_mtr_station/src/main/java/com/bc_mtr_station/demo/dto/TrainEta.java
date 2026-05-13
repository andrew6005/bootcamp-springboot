package com.bc_mtr_station.demo.service.dto;

public class TrainEta {
  private String destination;
  private String plat;
  private String time;
  private Integer seq;

  public String getDestination() { return destination; }
  public void setDestination(String destination) { this.destination = destination; }

  public String getPlat() { return plat; }
  public void setPlat(String plat) { this.plat = plat; }

  public String getTime() { return time; }
  public void setTime(String time) { this.time = time; }

  public Integer getSeq() { return seq; }
  public void setSeq(Integer seq) { this.seq = seq; }
}