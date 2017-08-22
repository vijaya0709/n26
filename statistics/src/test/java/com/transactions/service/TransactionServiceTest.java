package com.transactions.service;

import com.transactions.entity.Transaction;
import com.transactions.repositories.TransactionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.Instant;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TransactionServiceTest {

    @Test
    public void checkIfValidTrans() throws Exception {
        TransactionService t = new TransactionService();
        Instant then = Instant.ofEpochSecond(1503292919);
        assertFalse(t.checkIfValidTrans(then));
    }

}