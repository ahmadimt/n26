package com.imti.n26.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by imteyaz on 20/05/18
 **/

public class TransactionTest {

  @Test
  public void shouldCreateNonNullObject(){
    Transaction transaction = new Transaction(12.3,1478192204000l);
    Assert.assertNotNull(transaction);
  }

}
