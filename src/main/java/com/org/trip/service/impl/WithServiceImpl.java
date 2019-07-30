package com.org.trip.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.org.trip.mapper.UserMapper;
import com.org.trip.mapper.WithMapper;
import com.org.trip.service.WithService;
import com.org.trip.vo.WithVO;

@Service
public class WithServiceImpl implements WithService {

	@Resource
	private WithMapper wm;
	@Resource
	private UserMapper um;
	
	@Override
	public List<WithVO> getWithList() {
		List<WithVO> withs = new ArrayList<WithVO>();
		withs=wm.getWithList();
		for(int i=0;i<withs.size();i++) {
			withs.get(i).setWithWriter(um.getUserNick(withs.get(i).getUserNum()));
		}
		return withs;
	}

	@Override
	public WithVO getWith(WithVO with) {
		wm.countUp(with);
		return wm.getWith(with);
	}

	@Override
	public Integer insertWith(WithVO with) {
		return wm.insertWith(with);
	}

	@Override
	public Integer updateWith(WithVO with) {
		return wm.insertWith(with);
	}

	@Override
	public Integer deleteWith(WithVO with) {
		return wm.insertWith(with);
	}

	@Override
	public List<WithVO> getWithByUser(WithVO with) {
		return wm.getWithByUser(with);
	}
}
