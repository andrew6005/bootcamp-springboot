package com.bc_mtr_station.demo.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.client.RestTemplate;
import com.bc_mtr_station.demo.repository.LineRepository;
import com.bc_mtr_station.demo.repository.StationRepository;
import com.bc_mtr_station.demo.service.LineService;
import com.bc_mtr_station.demo.service.LineServiceImp;
import com.bc_mtr_station.demo.service.StationService;
@Configuration
public class Appconfig implements CommandLineRunner {

    private final LineRepository lineRepository;
    private final StationRepository stationRepository;
    private final LineService lineService;
    private final StationService stationService;

    public Appconfig(LineRepository lineRepository, StationRepository stationRepository, LineService lineService, StationService stationService) {
        this.lineRepository = lineRepository;
        this.stationRepository = stationRepository;
        this.lineService = lineService;
        this.stationService = stationService;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Override
    public void run(String... args) throws Exception {
        lineService.getLines().forEach(line -> lineRepository.save(line));
        stationService.getStations().forEach(station -> stationRepository.save(station));
    }   
}