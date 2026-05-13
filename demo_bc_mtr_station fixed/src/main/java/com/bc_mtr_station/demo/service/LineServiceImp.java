package com.bc_mtr_station.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bc_mtr_station.demo.repository.LineRepository;
import com.bc_mtr_station.demo.entity.LineEntity;
import java.util.List;
@Service
public class LineServiceImp implements LineService {
    @Autowired
    private final LineRepository lineRepository;

    public LineServiceImp(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    @Override
    public List<LineEntity> getLines() {
        return lineRepository.findAll();
    }
}