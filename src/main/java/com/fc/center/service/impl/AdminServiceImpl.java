package com.fc.center.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fc.center.config.DS;
import com.fc.center.mapper.AdminMapper;
import com.fc.center.model.Admin;
import com.fc.center.service.AdminService;

@Service(value ="adminService")
public class AdminServiceImpl implements AdminService {

	
	@Autowired
	private AdminMapper adminMapper;

	@Override
	@DS
	public Admin selectByPrimaryKey(Integer id) {
		return adminMapper.selectByPrimaryKey(id);
	}
	
	
	
}
