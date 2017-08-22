package com.transactions.service;

import com.transactions.entity.Statistics;
import com.transactions.entity.Transaction;
import com.transactions.repositories.TransactionRepository;
import com.transactions.util.StatisticsCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Component
public class StatisticsService {

    StatisticsCalculator statisticsCalculator;
    TransactionRepository transactionRepository;

    @Autowired
    public StatisticsService(StatisticsCalculator statisticsCalculator,TransactionRepository transactionRepository){
        this.statisticsCalculator = statisticsCalculator;
        this.transactionRepository = transactionRepository;
    }

    public Statistics getStatistics(){
        return statisticsCalculator.getStatistics(getAllTransactionsWithInRange());
    }

    public List<Transaction> getAllTransactionsWithInRange() {
        Instant now = Instant.now();
        Instant then = now.minusSeconds(60);
        return (List<Transaction>) transactionRepository.findByTimestampBetween(then.toEpochMilli(),now.toEpochMilli());
    }
}
