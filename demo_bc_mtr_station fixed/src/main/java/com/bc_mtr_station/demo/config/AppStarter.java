package com.bc_mtr_station.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bc_mtr_station.demo.repository.LineRepository;
import com.bc_mtr_station.demo.repository.StationRepository;
import com.bc_mtr_station.demo.service.LineService;
import com.bc_mtr_station.demo.service.StationService;
import com.bc_mtr_station.demo.service.MtrService;
import com.bc_mtr_station.demo.service.MtrResponseDto;

import com.bc_mtr_station.demo.entity.StationEntity;
import java.util.List;
@Component
public class AppStarter implements CommandLineRunner {
    private final LineRepository lineRepository;
    private final StationRepository stationRepository;
    private final LineService lineService;
    private final StationService stationService;
    private final MtrService mtrService;

    public AppStarter(LineRepository lineRepository, StationRepository stationRepository, LineService lineService, StationService stationService, MtrService mtrService) {
        this.lineRepository = lineRepository;
        this.stationRepository = stationRepository;
        this.lineService = lineService;
        this.stationService = stationService;
        this.mtrService = mtrService;
    }

    @Override
    public void run(String... args) throws Exception {
        lineService.getLines().forEach(line -> lineRepository.save(line));
        stationService.getStations().forEach(station -> stationRepository.save(station));
        List<String> lineCodes = lineService.getLineCodes();
        for (String lineCode : lineCodes) {
            MtrResponseDto mtrResponseDto = mtrService.getSchedule(lineCode, "MOK");
            List<String> stations = mtrResponseDto.getData().get("stations");
            for (String station : stations) {
                StationEntity stationEntity = new StationEntity();
                stationEntity.setLineCode(lineCode);
                stationEntity.setStationCode(station);
                stationRepository.save(stationEntity);
            }
        }
    }
}