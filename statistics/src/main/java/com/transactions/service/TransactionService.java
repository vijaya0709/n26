package com.transactions.service;

import com.transactions.entity.Transaction;
import com.transactions.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

@Component
public class TransactionService {

    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }

    public TransactionService(){}

    public void saveTransaction(Transaction t){
        transactionRepository.save(t);
    }

    public boolean checkIfValidTrans(Instant transactionTime) {
        Instant now = Instant.now();
        Duration duration = Duration.between(transactionTime,now);
        return duration.getSeconds() <=60;
    }
}
