package com.org.trip.mapper;

import java.util.List;

import com.org.trip.vo.TipVO;

public interface TipMapper {

	public List<TipVO> getTipList();
	public TipVO getTip(TipVO tip);
	public Integer insertTip(TipVO tip);
	public Integer updateTip(TipVO tip);
	public Integer deleteTip(TipVO tip);
}
