package com.fc.center.task;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fc.center.util.DateUtil;

@Component
public class task {
	
	  //每月1号2号晚上执行 每天晚上10点
	  @Scheduled(cron = "0 0 22 1-2 * ? ")
	  public void test() {
		  System.out.println("现在时间" + new Date());
	  }
	  
	  
	  
	  //，每天晚上10点 执行
	  @Scheduled(cron = "0 0 22 * * ? ")
	  public void shopCondition() {
		  Date date1 = DateUtil.getAfterMonthDayDate(1);
		  Date date2 = DateUtil.getAfterMonthDayDate(2);
		  Date datenow = new Date();
		  if(DateUtil.belongCalendar(datenow, date1, date2)) {
			  //to 执行  自动生成的结算单
			  
		  }else{
			  //to 手动   生成的结算单
		  }
		 
	  }
}
