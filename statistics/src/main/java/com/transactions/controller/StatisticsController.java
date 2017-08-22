package com.transactions.controller;

import com.transactions.entity.Statistics;
import com.transactions.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatisticsController {

	private StatisticsService statisticsService;

	public StatisticsController(@Autowired StatisticsService statisticsService)
	{
		this.statisticsService = statisticsService;
	}


    @RequestMapping(value = "/statistics",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public Statistics getStatistics(){
		return statisticsService.getStatistics();
	}
}
