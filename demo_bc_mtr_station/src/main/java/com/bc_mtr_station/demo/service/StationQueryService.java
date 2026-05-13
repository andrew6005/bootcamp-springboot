package com.bc_mtr_station.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bc_mtr_station.demo.dto.StationDto;
import com.bc_mtr_station.demo.exception.NotFoundException;
import com.bc_mtr_station.demo.repository.LineRepository;
import com.bc_mtr_station.demo.repository.StationRepository;

@Service
public class StationQueryService {

  private final LineRepository lineRepository;
  private final StationRepository stationRepository;

  public StationQueryService(LineRepository lineRepository, StationRepository stationRepository) {
    this.lineRepository = lineRepository;
    this.stationRepository = stationRepository;
  }

  public List<StationDto> getStationsByLine(String lineCode) {
    if (!lineRepository.existsByLineCode(lineCode)) {
      throw new NotFoundException("Line not found: " + lineCode);
    }
    return stationRepository.findAllByLineCode(lineCode).stream()
        .map(s -> new StationDto(s.getLineCode(), s.getStationCode()))
        .toList();
  }
}