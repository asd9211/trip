package com.org.trip.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.trip.service.ReviewService;
import com.org.trip.vo.ReviewVO;

@RestController
public class ReviewController {
	
	@Resource
	private ReviewService rs;
	
	@GetMapping("/reviews")
	public List<ReviewVO> getReviewList() {
		return rs.getReviewList();
	}
	@GetMapping("/review")
	public ReviewVO getReview(ReviewVO rv) {
		return rs.getReview(rv);
	}
	@GetMapping("/review/{userNum}")
	public List<ReviewVO> getReviewByUser(@PathVariable("userNum") Integer userNum) {
		ReviewVO rv = new ReviewVO();
		rv.setUserNum(userNum);
		return rs.getReviewByUser(rv);
	}
	@PostMapping("/review")
	public Integer insertReview(ReviewVO rv) {
		return rs.insertReview(rv);
	}
	@PutMapping("/review")
	public Integer updateReview(ReviewVO rv) {
		return rs.updateReview(rv);
	}
	//별점은내일
	@DeleteMapping("/review")
	public Integer deleteReview(ReviewVO rv) {
		return rs.deleteReview(rv);
	}
}
