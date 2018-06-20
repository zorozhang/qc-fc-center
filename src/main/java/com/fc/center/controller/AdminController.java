package com.fc.center.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fc.center.service.impl.AdminServiceImpl;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	   @Autowired
	   private AdminServiceImpl adminServiceImpl;
	   
	   
	   @ResponseBody
	   @GetMapping("/selectOne")
	   public Object selectOne(int id) {
		    return adminServiceImpl.selectByPrimaryKey(id);
	   }
	   
}
