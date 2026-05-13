package com.bc_mtr_station.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "line_stations")
public class StationEntity {

    @Id
    @Column(name = "station_code")
    private String stationCode;

    @Column(name = "line_code")
    private String lineCode;

    public StationEntity() {
    }

    public StationEntity(String lineCode, String stationCode) {
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
