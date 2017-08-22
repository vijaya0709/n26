package com.transactions.controller;

import com.sun.media.sound.InvalidDataException;
import com.transactions.entity.Transaction;
import com.transactions.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;


@RestController
public class TransactionController {

    private TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @RequestMapping(value = "/transactions",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void saveTransaction(@RequestBody Transaction t) throws InvalidDataException {
        Instant transactionTime = Instant.ofEpochMilli(t.getTimestamp());
        if(!transactionService.checkIfValidTrans(transactionTime))
            throw new InvalidDataException();
        transactionService.saveTransaction(t);
    }

}
