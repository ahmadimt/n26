package com.imti.n26.controller;

/**
 * Created by imteyaz on 21/05/18
 **/

import com.imti.n26.RestApiApplication;
import com.imti.n26.dtos.Statistics;
import com.imti.n26.model.Transaction;
import com.imti.n26.service.TransactionService;
import java.time.Instant;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestApiApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class StatisticsControllerTest {

  @LocalServerPort
  private int port;

  private TestRestTemplate restTemplate;

  private HttpHeaders headers;

  @Autowired
  private TransactionService transactionService;


  @Before
  public void setup() throws InterruptedException {
    restTemplate = new TestRestTemplate();
    headers = new HttpHeaders();
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
  }

  @Test
  public void shouldGiveStatistics() {
    ResponseEntity<Statistics> response = restTemplate
        .getForEntity(createUrl(), Statistics.class);
    Assert.assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
    Assert.assertEquals(5, response.getBody().getCount());
    Assert.assertEquals(12.4, response.getBody().getMin(), 0);
    Assert.assertEquals(45.6, response.getBody().getMax(), 0);
    Assert.assertEquals(33.56, response.getBody().getAvg(), 0);
    Assert.assertEquals(167.8, response.getBody().getSum(), 0);
  }

  private String createUrl() {
    return "http://localhost:" + port + "/statistics";
  }


}
