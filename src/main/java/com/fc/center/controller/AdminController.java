package com.fc.center.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fc.center.model.Admin;
import com.fc.center.service.impl.AdminServiceImpl;
import com.fc.center.vo.ResultVO;


@RestController
@RequestMapping(value = "/admin")
public class AdminController {

	 private Logger logger = LoggerFactory.getLogger(this.getClass());  
	
	   @Autowired
	   private AdminServiceImpl adminServiceImpl;
	   
	   
	   @GetMapping("/selectOne")
	   public ResultVO<Admin> selectOne(int id) {
		   ResultVO<Admin> sd = new ResultVO<>();
		   logger.info("logback 成功了");
	        logger.error("logback 成功了");
	        logger.debug("logback 成功了");
		   sd.setData(adminServiceImpl.selectByPrimaryKey(id));
		   sd.setMsg("s");
		   sd.setCode(0);
		   return sd;
	   }
	   
}
