package com.org.trip.service;

import java.util.List;

import com.org.trip.vo.ReviewVO;
import com.org.trip.vo.SpVO;

public interface ReviewService {

	public List<ReviewVO> getReviewList();
	public ReviewVO getReview(ReviewVO rv);
	public List<ReviewVO> getReviewByUser(ReviewVO rv);
	public Integer insertReview(ReviewVO rv);
	public Integer updateReview(ReviewVO rv);
	public Integer avgSp(ReviewVO rv);
	public Integer deleteReview(ReviewVO rv);
}
