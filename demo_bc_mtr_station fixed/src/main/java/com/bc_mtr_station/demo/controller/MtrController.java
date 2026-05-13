package com.bc_mtr_station.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bc_mtr_station.demo.entity.LineEntity;
import com.bc_mtr_station.demo.repository.LineRepository;

@RestController
@RequestMapping("/mtr")
public class MtrController {

    private final LineRepository lineRepository;

    public MtrController(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    @PostMapping("/lines")
    public LineEntity createLine(@RequestBody LineEntity line) {
        return lineRepository.save(line);
    }

@PutMapping("/lines/{id}")
public LineEntity updateLine(@PathVariable String id, @RequestBody LineEntity request) {
    LineEntity line = lineRepository.findById(id).orElse(null);

    if (line == null) {
        line = new LineEntity();
        line.setLineCode(id);
    }

    line.setLineName(request.getLineName());

    return lineRepository.save(line);
}

@GetMapping("/schedule")
public String getSchedule(@RequestParam String line, @RequestParam String sta) {
    return "line = " + line + ", sta = " + sta;
}


}