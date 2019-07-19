package com.org.trip.mapper;

import java.util.List;

import com.org.trip.vo.WithVO;

public interface WithMapper {

	public List<WithVO> getWithList();
	public WithVO getWith(WithVO with);
	public List<WithVO> getWithByUser(WithVO with);
	public Integer insertWith(WithVO with);
	public Integer updateWith(WithVO with);
	public Integer deleteWith(WithVO with);
	public Integer countUp(WithVO with);
}
