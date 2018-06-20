package com.fc.center.task;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class task {
   
	
	  @Scheduled(cron = "4-40 * * * * ?")
	  public void test() {
		  System.out.println("现在时间" + new Date());
	  }
	
}
