package com.imti.n26.controller;

import com.imti.n26.RestApiApplication;
import com.imti.n26.model.Transaction;
import java.time.Instant;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by imteyaz on 21/05/18
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestApiApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class TransactionControllerTest {

  @LocalServerPort
  private int port;

  private TestRestTemplate restTemplate;

  private HttpHeaders headers;

  @Before
  public void setup() {
    restTemplate = new TestRestTemplate();
    headers = new HttpHeaders();
  }


  @Test
  public void shouldReturn201WithNoBody() {
    Transaction transaction = new Transaction(12.3, Instant.now().toEpochMilli());
    HttpEntity<Transaction> entity = new HttpEntity<>(transaction, headers);
    ResponseEntity<ResponseEntity> exchange = restTemplate.
        exchange(createUrl(), HttpMethod.POST, entity,
            ResponseEntity.class);
    Assert.assertEquals(201, exchange.getStatusCodeValue());
  }

  @Test
  public void shouldReturn204WithNoBody() {
    Transaction transaction = new Transaction(12.3, 1478192204000l);
    HttpEntity<Transaction> entity = new HttpEntity<>(transaction, headers);
    ResponseEntity<ResponseEntity> exchange = restTemplate.
        exchange(createUrl(), HttpMethod.POST, entity,
            ResponseEntity.class);
    Assert.assertEquals(204, exchange.getStatusCodeValue());
  }

  private String createUrl() {
    return "http://localhost:" + port + "/transactions";
  }

}
