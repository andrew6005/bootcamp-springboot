package com.bc_mtr_station.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.bc_mtr_station.demo.dto.LineDto;
import com.bc_mtr_station.demo.service.LineQueryService;

@RestController
@RequestMapping("/mtr/lines")
public class LineController {

  private final LineQueryService lineQueryService;

  public LineController(LineQueryService lineQueryService) {
    this.lineQueryService = lineQueryService;
  }

  @GetMapping
  public List<LineDto> getLines() {
    return lineQueryService.getAllLines();
  }

  @GetMapping("/{lineCode}")
  public LineDto getLine(@PathVariable String lineCode) {
    return lineQueryService.getLine(lineCode);
  }
}