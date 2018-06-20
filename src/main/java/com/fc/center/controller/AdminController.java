package com.fc.center.controller;

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

	   @Autowired
	   private AdminServiceImpl adminServiceImpl;
	   
	   
	   @GetMapping("/selectOne")
	   public ResultVO<Admin> selectOne(int id) {
		   ResultVO<Admin> sd = new ResultVO<>();
		   sd.setData(adminServiceImpl.selectByPrimaryKey(id));
		   sd.setMsg("s");
		   sd.setCode(0);
		   return sd;
	   }
	   
}
