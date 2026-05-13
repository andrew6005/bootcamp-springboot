package com.bc_mtr_station.demo.dto;

public class StationDto {
    private String lineCode;
    private String stationCode;

    public StationDto() {
    } 

    public StationDto(String lineCode, String stationCode) {
        this.lineCode = lineCode;
        this.stationCode = stationCode;
    }

    public String getLineCode() {
        return lineCode;
    } 

    public void setLineCode(String lineCode) {
        this.lineCode = lineCode;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }
}
