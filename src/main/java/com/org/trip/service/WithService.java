package com.org.trip.service;

import java.util.List;

import com.org.trip.vo.WithVO;

public interface WithService {
	public List<WithVO> getWithList();
	public WithVO getWith(WithVO with);
	public Integer insertWith(WithVO with);
	public Integer updateWith(WithVO with);
	public Integer deleteWith(WithVO with);
}
