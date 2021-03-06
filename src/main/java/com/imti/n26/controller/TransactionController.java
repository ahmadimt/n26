package com.imti.n26.controller;

import com.imti.n26.model.Transaction;
import com.imti.n26.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by imteyaz on 20/05/18
 **/

@RestController
public class TransactionController {


  private final TransactionService transactionService;

  @Value("${time.limit.in.second:60}")
  private long duration;

  @Autowired
  public TransactionController(TransactionService transactionService) {
    this.transactionService = transactionService;
  }

  @PostMapping(value = "/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity transactions(@RequestBody Transaction transaction) {
    ResponseEntity responseEntity;
    if (transactionService.saveTransaction(transaction)) {
      responseEntity = new ResponseEntity(HttpStatus.CREATED);
    } else {
      responseEntity = new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    return responseEntity;
  }
}
