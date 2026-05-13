package com.bc_mtr_station.demo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.bc_mtr_station.demo.repository.LineRepository;
import com.bc_mtr_station.demo.repository.StationRepository;

@Service
public class MtrService {

    @SuppressWarnings("unused")
    private final StationRepository stationRepository;
    @SuppressWarnings("unused")
    private final LineRepository lineRepository;
    private final RestTemplate restTemplate;

    public MtrService(StationRepository stationRepository,
                      LineRepository lineRepository,
                      RestTemplate restTemplate) {
        this.stationRepository = stationRepository;
        this.lineRepository = lineRepository;
        this.restTemplate = restTemplate;
    }

    public MtrResponseDto getSchedule(String line, String sta) {

        String url = "https://rt.data.gov.hk/v1/transport/mtr/getSchedule.php"
                + "?line=" + line
                + "&sta=" + sta
                + "&lang=EN";

        return restTemplate.getForObject(url, MtrResponseDto.class);
    }

    public List<String> getLineCodes() {
        return Arrays.asList(
                "AEL", "TCL", "TML", "TKL", "EAL",
                "SIL", "TWL", "ISL", "KTL", "DRL"
        );
    }
}