package com.org.trip.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.org.trip.mapper.SpMapper;
import com.org.trip.service.SpService;
import com.org.trip.vo.SpVO;

@Service
public class SpServiceImpl implements SpService {

	@Resource 
	private SpMapper sm;
	
	@Override
	public Integer insertSp(SpVO sp) {
		return sm.insertSp(sp);
	}

	@Override
	public Integer deleteSp(SpVO sp) {
		return sm.deleteSp(sp);
	}

}
