package com.transactions.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.transactions.entity.Statistics;
import com.transactions.repositories.TransactionRepository;
import com.transactions.service.StatisticsService;
import com.transactions.util.StatisticsCalculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(StatisticsController.class)
public class StatisticsControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private StatisticsService statisticsService;
    @MockBean
    StatisticsCalculator statisticsCalculator;
    @MockBean
    TransactionRepository transactionRepository;




    @Test
    public void validStatistics() throws Exception {
        Statistics statistics = new Statistics(37D,18.5D,19.5D,17.5D,2L);
        when(statisticsService.getStatistics()).thenReturn(statistics);
        mvc.perform(get("/statistics").accept("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("application/json"))
                .andExpect(jsonPath("count", is(2)))
                .andExpect(jsonPath("sum", is(37.0)))
                .andExpect(jsonPath("avg", is(18.5)))
                .andExpect(jsonPath("max", is(19.5)))
                .andExpect(jsonPath("min", is(17.5)));
    }

}