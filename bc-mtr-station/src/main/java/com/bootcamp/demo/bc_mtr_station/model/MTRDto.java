package com.bootcamp.demo.bc_mtr_station.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

// JSON String -> Java Object (Deserialization)

@Getter
public class MTRDto {
  @JsonProperty(value = "sys_time")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime sysTime;
  @JsonProperty(value = "curr_time")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime currTime;
  // ! Key: TKL-TKO, Value: {}
  // One Entry ONLY
  private Map<String, Schedule> data;

  @Getter
  public static class Schedule {
    @JsonProperty(value = "sys_time")
    private LocalDateTime sysTime;
    @JsonProperty(value = "curr_time")
    private LocalDateTime currTime;
    @JsonProperty(value = "UP")
    private List<Train> upTrains;
    @JsonProperty(value = "DOWN")
    private List<Train> downTrains;
    @JsonProperty(value = "isdelay")
    private String isDelay;
    private String status;
    private String message;

    @Getter
    public static class Train {
      private String seq;
      private String dest;
      private String plat;
      @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
      private LocalDateTime time;
      private String ttnt;
      private String valid;
      private String source;
    }
  }
}
