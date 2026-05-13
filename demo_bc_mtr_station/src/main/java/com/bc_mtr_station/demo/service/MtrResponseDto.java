package com.bc_mtr_station.demo.service;

import java.util.Map;

public class MtrResponseDto {

    private String sys_time;
    private String curr_time;
    private Map<String, Object> data;
    private Integer status;
    private String message;
    private String isdelay;

    public String getSys_time() {
        return sys_time;
    }

    public void setSys_time(String sys_time) {
        this.sys_time = sys_time;
    }

    public String getCurr_time() {
        return curr_time;
    }

    public void setCurr_time(String curr_time) {
        this.curr_time = curr_time;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getIsdelay() {
        return isdelay;
    }

    public void setIsdelay(String isdelay) {
        this.isdelay = isdelay;
    }
}