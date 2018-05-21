package com.imti.n26.service;

import com.imti.n26.model.Transaction;
import java.util.Map;

/**
 * Created by imteyaz on 20/05/18
 **/

public interface TransactionService {

  boolean saveTransaction(Transaction transaction);

  Map<Long,Double> findTransactions();
}
