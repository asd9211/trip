package com.org.trip.mapper;

import com.org.trip.vo.LikeVO;

public interface LikeMapper {
	
	public LikeVO getLike(LikeVO like);
	public Integer insertLike(LikeVO like);
	public Integer deleteLike(LikeVO like);	
}
