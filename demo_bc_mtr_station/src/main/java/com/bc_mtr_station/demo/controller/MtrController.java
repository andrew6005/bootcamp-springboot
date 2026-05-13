package com.bc_mtr_station.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import com.bc_mtr_station.demo.service.MtrResponseDto;
import com.bc_mtr_station.demo.service.MtrService;

@RestController
public class MtrController {

    private final MtrService mtrService;

    public MtrController(MtrService mtrService) {
        this.mtrService = mtrService;
    }

    @GetMapping("/mtr/schedule")
    public MtrResponseDto getSchedule(@RequestParam String line,
                                      @RequestParam String sta) {
        return mtrService.getSchedule(line, sta);
    }
}