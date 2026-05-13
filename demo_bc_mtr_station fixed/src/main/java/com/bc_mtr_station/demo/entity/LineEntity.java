package com.bc_mtr_station.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mtr_lines")
public class LineEntity {

    @Id
    @Column(name = "line_code")
    private String lineCode;

    @Column(name = "line_name")
    private String lineName;

    public LineEntity() {
    }

    public LineEntity(String lineCode, String lineName) {
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
