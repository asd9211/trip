package com.org.trip.service;

import java.util.List;

import com.org.trip.vo.TipVO;

public interface TipService {

	public List<TipVO> getTipList();
	public TipVO getTip(TipVO tip);
	public Integer insertTip(TipVO tip);
	public Integer updateTip(TipVO tip);
	public Integer deleteTip(TipVO tip);
}
