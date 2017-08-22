package com.transactions.util;

import com.transactions.entity.Statistics;
import com.transactions.entity.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class StatisticsCalculatorTest {

    private List<Transaction> transactions;
    StatisticsCalculator calculator;
    Statistics statistics;

    @Before
    public void setUp(){
        transactions = Arrays.asList(new Transaction(17.5, Instant.now().toEpochMilli()),
                new Transaction(15.5, Instant.now().minusSeconds(5).toEpochMilli()),
                new Transaction(14.5, Instant.now().minusSeconds(10).toEpochMilli()));
        calculator = new StatisticsCalculator();
        statistics = calculator.getStatistics(transactions);
    }


    @Test
    public void testCount(){
        assertEquals(new Long(3),statistics.getCount());
    }

    @Test
    public void testAvg(){
        assertEquals(new Double(15.833333333333334),statistics.getAvg());
    }

    @Test
    public void testMax(){
        assertEquals(new Double(17.5),statistics.getMax());
    }

    @Test
    public void testMin(){
        assertEquals(new Double(14.5),statistics.getMin());
    }

    @Test
    public void testSum(){
        assertEquals(new Double(47.5),statistics.getSum());
    }



}