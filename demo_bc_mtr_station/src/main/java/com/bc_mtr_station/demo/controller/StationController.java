package com.bc_mtr_station.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.bc_mtr_station.demo.dto.StationDto;
import com.bc_mtr_station.demo.service.StationQueryService;

@RestController
@RequestMapping("/mtr")
public class StationController {

  private final StationQueryService stationQueryService;

  public StationController(StationQueryService stationQueryService) {
    this.stationQueryService = stationQueryService;
  }

  @GetMapping("/lines/{lineCode}/stations")
  public List<StationDto> getStationsByLine(@PathVariable String lineCode) {
    return stationQueryService.getStationsByLine(lineCode);
  }
}