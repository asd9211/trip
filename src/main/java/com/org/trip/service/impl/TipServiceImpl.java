package com.org.trip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.org.trip.mapper.TipMapper;
import com.org.trip.service.TipService;
import com.org.trip.vo.TipVO;

@Service
public class TipServiceImpl implements TipService {
	
	@Resource
	private TipMapper tm;

	@Override
	public List<TipVO> getTipList() {
		return tm.getTipList();
	}

	@Override
	public TipVO getTip(TipVO tip) {
		return tm.getTip(tip);
	}

	@Override
	public Integer insertTip(TipVO tip) {
		return tm.insertTip(tip);
	}

	@Override
	public Integer updateTip(TipVO tip) {
		return tm.updateTip(tip);
	}

	@Override
	public Integer deleteTip(TipVO tip) {
		return tm.deleteTip(tip);
	}

}
