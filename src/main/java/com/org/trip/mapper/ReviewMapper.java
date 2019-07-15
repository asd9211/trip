package com.org.trip.mapper;

import java.util.List;

import com.org.trip.vo.ReviewVO;

public interface ReviewMapper {

	public List<ReviewVO> getReviewList();
	public ReviewVO getReview(ReviewVO rv);
}
