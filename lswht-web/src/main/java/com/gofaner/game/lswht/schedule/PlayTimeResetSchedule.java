package com.gofaner.game.lswht.schedule;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.gofaner.game.lswht.service.IUserService;

@Service
public class PlayTimeResetSchedule {
	Logger logger = Logger.getLogger(PlayTimeResetSchedule.class);
	
	@Autowired
	private IUserService userService;

	//@Scheduled(fixedDelay = 1000)
	//@Scheduled(cron="0 32 10 ? * *")
	/**
	 * execute at 0:10AM every day
	 */
	@Scheduled(cron="0 10 0 ? * *")
	public void doTask() {
		logger.info("reseting play time ...");
		userService.resetPlayTime();
		logger.info("reset play time done!");
	}
}
