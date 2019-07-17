package com.org.trip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.org.trip.mapper.WithMapper;
import com.org.trip.service.WithService;
import com.org.trip.vo.WithVO;

@Service
public class WithServiceImpl implements WithService {

	@Resource
	private WithMapper wm;
	
	@Override
	public List<WithVO> getWithList() {
		return wm.getWithList();
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
}
