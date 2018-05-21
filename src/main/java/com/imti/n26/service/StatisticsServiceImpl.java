package com.imti.n26.service;

import com.imti.n26.dtos.Statistics;
import com.imti.n26.utils.Validator;
import java.util.Map.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by imteyaz on 20/05/18
 **/

@Service
public class StatisticsServiceImpl implements StatisticsService {


  private final TransactionService transactionService;

  @Value("${time.limit.in.second:60}")
  private long duration;

  @Autowired
  public StatisticsServiceImpl(TransactionService transactionService) {
    this.transactionService = transactionService;
  }

  @Override
  public Statistics calculateStatistics() {
    //Map<Long, Double> transactions = transactionService.findTransactions();
    return Statistics.from(transactionService.findTransactions().entrySet().stream()
        .filter(longDoubleEntry -> Validator.validateTimestamp(longDoubleEntry.getKey(),duration))
        .mapToDouble(Entry::getValue).summaryStatistics());
  }
}
