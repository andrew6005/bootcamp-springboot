package com.bc_mtr_station.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.bc_mtr_station.demo.service.ScheduleService;
import com.bc_mtr_station.demo.service.dto.ScheduleResponse;

@RestController
@RequestMapping("/mtr")
public class ScheduleController {

  private final ScheduleService scheduleService;

  public ScheduleController(ScheduleService scheduleService) {
    this.scheduleService = scheduleService;
  }

  @GetMapping("/schedule")
  public ScheduleResponse getSchedule(@RequestParam String line, @RequestParam String sta) {
    return scheduleService.getSchedule(line, sta);
  }
}