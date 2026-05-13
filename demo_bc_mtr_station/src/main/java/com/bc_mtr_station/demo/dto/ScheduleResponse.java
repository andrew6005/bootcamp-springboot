package com.bc_mtr_station.demo.service.dto;

import java.util.List;

public class ScheduleResponse {
  private String line;
  private String station;
  private String sysTime;
  private String currTime;
  private boolean delay;
  private List<TrainEta> up;
  private List<TrainEta> down;

  public String getLine() { return line; }
  public void setLine(String line) { this.line = line; }

  public String getStation() { return station; }
  public void setStation(String station) { this.station = station; }

  public String getSysTime() { return sysTime; }
  public void setSysTime(String sysTime) { this.sysTime = sysTime; }

  public String getCurrTime() { return currTime; }
  public void setCurrTime(String currTime) { this.currTime = currTime; }

  public boolean isDelay() { return delay; }
  public void setDelay(boolean delay) { this.delay = delay; }

  public List<TrainEta> getUp() { return up; }
  public void setUp(List<TrainEta> up) { this.up = up; }

  public List<TrainEta> getDown() { return down; }
  public void setDown(List<TrainEta> down) { this.down = down; }
}