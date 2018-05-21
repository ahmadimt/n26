package com.imti.n26.service;

import com.imti.n26.dtos.Statistics;
import com.imti.n26.model.Transaction;
import java.time.Instant;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by imteyaz on 20/05/18
 **/

@SpringBootTest
@RunWith(SpringRunner.class)
public class StatisticsServiceTest {

  @Autowired
  private TransactionServiceImpl transactionService;

  @Autowired
  private StatisticsServiceImpl statisticsService;

  @Test
  public void shouldReturnTransactionsStatistics() throws InterruptedException {
    Transaction transaction = new Transaction(12.4,
        Instant.now().toEpochMilli());
    transactionService.saveTransaction(transaction);
    Thread.sleep(1000);
    Transaction transaction1 = new Transaction(34.5,
        Instant.now().toEpochMilli());
    transactionService.saveTransaction(transaction1);
    Thread.sleep(1000);
    Transaction transaction2 = new Transaction(36.3,
        Instant.now().toEpochMilli());
    transactionService.saveTransaction(transaction2);
    Thread.sleep(1000);
    Transaction transaction3 = new Transaction(39.0,
        Instant.now().toEpochMilli());
    transactionService.saveTransaction(transaction3);
    Thread.sleep(1000);
    Transaction transaction4 = new Transaction(45.6,
        Instant.now().toEpochMilli());
    transactionService.saveTransaction(transaction4);
    Thread.sleep(1000);
    Statistics statistics = statisticsService.calculateStatistics();
    Assert.assertEquals(5, statistics.getCount());
    Assert.assertEquals(12.4, statistics.getMin(), 0);
    Assert.assertEquals(45.6, statistics.getMax(), 0);
    Assert.assertEquals(33.56, statistics.getAvg(), 0);
    Assert.assertEquals(167.8, statistics.getSum(), 0);
  }

}
