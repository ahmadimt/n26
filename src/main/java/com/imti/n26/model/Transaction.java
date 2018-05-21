package com.imti.n26.model;

import lombok.ToString;

/**
 * Created by imteyaz on 20/05/18
 **/

@ToString
public class Transaction {

  private double amount;

  private long timestamp;

  public Transaction() {
  }

  public Transaction(double amount, long timestamp) {
    this.amount = amount;
    this.timestamp = timestamp;
  }

  public double getAmount() {
    return amount;
  }

  public long getTimestamp() {
    return timestamp;
  }

}
