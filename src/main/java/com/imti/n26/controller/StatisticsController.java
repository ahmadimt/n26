package com.imti.n26.controller;

import com.imti.n26.dtos.Statistics;
import com.imti.n26.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by imteyaz on 20/05/18
 **/

@RestController
public class StatisticsController {

  private final StatisticsService statisticsService;

  @Autowired
  public StatisticsController(StatisticsService statisticsService) {
    this.statisticsService = statisticsService;
  }

  @GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Statistics> getStatistics() {
    return ResponseEntity.ok(statisticsService.calculateStatistics());
  }
}
