package com.imti.n26.service;

import com.imti.n26.model.Transaction;
import com.imti.n26.utils.Validator;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by imteyaz on 20/05/18
 **/

@Service
public class TransactionServiceImpl implements TransactionService {

  @Value("${time.limit.in.second:60}")
  private long duration;

  private Map<Long, Double> transactions = new ConcurrentHashMap<>();

  @Override
  public boolean saveTransaction(Transaction transaction) {
    boolean flag = false;
    if (Validator.validateTimestamp(transaction.getTimestamp(), duration)) {
      transactions.put(transaction.getTimestamp(), transaction.getAmount());
      flag = true;
    }
    return flag;
  }

  @Override
  public Map<Long, Double> findTransactions() {
    return transactions;
  }
}
