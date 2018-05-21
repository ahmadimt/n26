package com.imti.n26.service;

import com.imti.n26.dtos.Statistics;
import java.util.DoubleSummaryStatistics;

/**
 * Created by imteyaz on 20/05/18
 **/

public interface StatisticsService {

  Statistics calculateStatistics();

}
