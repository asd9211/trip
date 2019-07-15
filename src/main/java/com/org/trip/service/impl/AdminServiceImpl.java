package com.org.trip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.org.trip.mapper.AdminMapper;
import com.org.trip.service.AdminService;
import com.org.trip.vo.AdminVO;

@Service
public class AdminServiceImpl implements AdminService {

	@Resource
	private AdminMapper am;
	@Override
	public List<AdminVO> getAdminList() {
		return am.getAdminList();
	}
	
}
