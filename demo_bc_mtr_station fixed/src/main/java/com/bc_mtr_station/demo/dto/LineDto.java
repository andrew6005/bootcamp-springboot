package com.bc_mtr_station.demo.dto;

public class LineDto {
    private String lineCode;
    private String lineName;

    public LineDto() {
    }

    public LineDto(String lineCode, String lineName) {
        this.lineCode = lineCode;
        this.lineName = lineName;
    }

    public String getLineCode() {
        return lineCode;
    }

    public void setLineCode(String lineCode) {
        this.lineCode = lineCode;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }
}
