package com.bc_mtr_station.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bc_mtr_station.demo.dto.LineDto;
import com.bc_mtr_station.demo.entity.LineEntity;
import com.bc_mtr_station.demo.exception.NotFoundException;
import com.bc_mtr_station.demo.repository.LineRepository;

@Service
public class LineQueryService {
  private final LineRepository lineRepository;

  public LineQueryService(LineRepository lineRepository) {
    this.lineRepository = lineRepository;
  }

  public List<LineDto> getAllLines() {
    return lineRepository.findAll().stream()
        .map(e -> new LineDto(e.getLineCode(), e.getLineName()))
        .toList();
  }

  public LineDto getLine(String lineCode) {
    LineEntity e = lineRepository.findByLineCode(lineCode)
        .orElseThrow(() -> new NotFoundException("Line not found: " + lineCode));
    return new LineDto(e.getLineCode(), e.getLineName());
  }
}