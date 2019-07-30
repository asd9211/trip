package com.org.trip.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.org.trip.mapper.ReviewMapper;
import com.org.trip.mapper.SpMapper;
import com.org.trip.service.SpService;
import com.org.trip.vo.ReviewVO;
import com.org.trip.vo.SpVO;

@Service
public class SpServiceImpl implements SpService {
	ReviewVO rv = new ReviewVO();
	@Resource 
	private SpMapper sm;
	@Resource
	private ReviewMapper rm;
	
	@Override
	public Integer insertSp(SpVO sp) {
		if(sm.insertSp(sp)==1) {
			rv.setRvNum(sp.getRvNum());
			if(rm.avgSp(rv)==1) {
			return 1;
			}
		}
		return 0;
	}

	@Override
	public Integer deleteSp(SpVO sp) {
		return sm.deleteSp(sp);
	}

}
