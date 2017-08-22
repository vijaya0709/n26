package com.transactions.util;

import com.transactions.entity.Statistics;
import com.transactions.entity.Transaction;
import org.springframework.stereotype.Component;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StatisticsCalculator {

    public synchronized Statistics getStatistics(List<Transaction> transactionList) {
        if(transactionList == null || transactionList.isEmpty())
            return new Statistics(0D,0D,0D,0D,0L);

        DoubleSummaryStatistics statistics = transactionList
                .parallelStream().collect(Collectors.summarizingDouble(Transaction::getAmount));

       return new Statistics( statistics.getSum(),
                            statistics.getAverage(),
                            statistics.getMax(),
                            statistics.getMin(),
                            statistics.getCount());
    }
}
