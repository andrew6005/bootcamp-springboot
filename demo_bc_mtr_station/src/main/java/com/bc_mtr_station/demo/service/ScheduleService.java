package com.bc_mtr_station.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bc_mtr_station.demo.exception.BadRequestException;
import com.bc_mtr_station.demo.exception.UpstreamException;
import com.bc_mtr_station.demo.repository.LineRepository;
import com.bc_mtr_station.demo.repository.StationRepository;
import com.bc_mtr_station.demo.service.dto.ScheduleResponse;
import com.bc_mtr_station.demo.service.dto.TrainEta;

@Service
public class ScheduleService {

  private final LineRepository lineRepository;
  private final StationRepository stationRepository;
  private final MtrService mtrService;

  public ScheduleService(LineRepository lineRepository, StationRepository stationRepository, MtrService mtrService) {
    this.lineRepository = lineRepository;
    this.stationRepository = stationRepository;
    this.mtrService = mtrService;
  }

  public ScheduleResponse getSchedule(String line, String sta) {
    if (!lineRepository.existsByLineCode(line)) {
      throw new BadRequestException("INVALID_LINE");
    }
    if (!stationRepository.existsByLineCodeAndStationCode(line, sta)) {
      throw new BadRequestException("INVALID_STATION");
    }

    MtrResponseDto raw = mtrService.getSchedule(line, sta);

    if (raw == null) {
      throw new UpstreamException("MTR_UPSTREAM_NULL");
    }
    if (raw.getStatus() == null || raw.getStatus() != 1) {
      throw new UpstreamException(raw.getMessage() == null ? "MTR_UPSTREAM_ERROR" : raw.getMessage());
    }

    ScheduleResponse res = new ScheduleResponse();
    res.setLine(line);
    res.setStation(sta);
    res.setSysTime(raw.getSys_time());
    res.setCurrTime(raw.getCurr_time());
    res.setDelay("Y".equalsIgnoreCase(raw.getIsdelay()));

    // raw.getData() is Map<String,Object>; parse UP/DOWN lists defensively
    Map<String, Object> data = raw.getData();
    if (data != null) {
      Object stationKeyObj = data.get(line + "-" + sta);
      if (stationKeyObj instanceof Map<?, ?> stationMap) {
        res.setUp(readEtaList(stationMap.get("UP")));
        res.setDown(readEtaList(stationMap.get("DOWN")));
      }
    }

    return res;
  }

  @SuppressWarnings("unchecked")
  private List<TrainEta> readEtaList(Object obj) {
    if (!(obj instanceof List<?> list)) return List.of();
    List<TrainEta> out = new ArrayList<>();
    for (Object item : list) {
      if (item instanceof Map<?, ?> m) {
        TrainEta t = new TrainEta();
        Object dest = m.get("dest");
        Object plat = m.get("plat");
        Object time = m.get("time");
        Object seq = m.get("seq");
        t.setDestination(dest == null ? null : dest.toString());
        t.setPlat(plat == null ? null : plat.toString());
        t.setTime(time == null ? null : time.toString());
        if (seq != null) {
          try { t.setSeq(Integer.parseInt(seq.toString())); } catch (Exception ignored) {}
        }
        out.add(t);
      }
    }
    return out;
  }
}