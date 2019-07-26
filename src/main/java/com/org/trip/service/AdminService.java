package com.org.trip.service;

import java.util.List;

import com.org.trip.vo.AdminVO;

public interface AdminService {

	public List<AdminVO> getAdminList();
	public AdminVO getAdminLogin(AdminVO admin);
}
