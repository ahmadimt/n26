package com.imti.n26.service;

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
public class TransactionServiceTest {

  @Autowired
  private TransactionService transactionService;

  @Test
  public void shouldCreateNonNullServiceObject() {
    TransactionServiceImpl service = new TransactionServiceImpl();
    Assert.assertNotNull(service);
  }

  @Test
  public void shouldSaveTransaction() {
    boolean flag = transactionService
        .saveTransaction(new Transaction(12.3, Instant.now().toEpochMilli()));
    Assert.assertEquals(true, flag);
  }

  @Test
  public void shouldNotSaveTransaction() {
    boolean flag = transactionService
        .saveTransaction(new Transaction(12.3, 1478192204000l));
    Assert.assertEquals(false, flag);
  }
}
