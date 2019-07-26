package com.org.trip.mapper;

import java.util.List;

import com.org.trip.vo.ReviewVO;

public interface ReviewMapper {

	public List<ReviewVO> getReviewList();
	public ReviewVO getReview(ReviewVO rv);
	public List<ReviewVO> getReviewByUser(ReviewVO rv);
	public Integer insertReview(ReviewVO rv);
	public Integer updateReview(ReviewVO rv);
	public Integer countUp(ReviewVO rv);
	public Integer avgSp(ReviewVO rv);
	public Integer deleteReview(ReviewVO rv);
	public Integer likeUp(ReviewVO rv);
}
