package com.org.trip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.org.trip.mapper.ReviewMapper;
import com.org.trip.service.ReviewService;
import com.org.trip.util.InsertPic;
import com.org.trip.vo.ReviewVO;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Resource
	private ReviewMapper rm;
	@Resource
	private InsertPic ip;

	@Override
	public List<ReviewVO> getReviewList() {
		return rm.getReviewList();
	}

	@Override
	public ReviewVO getReview(ReviewVO rv) {
		rm.countUp(rv);
		return rm.getReview(rv);
	}

	@Override
	public ReviewVO getReviewByUser(ReviewVO rv) {
		return rm.getReviewByUser(rv);
	}

	@Override
	public Integer insertReview(ReviewVO rv) {
		if(rv.getRvFile()!=null) {
			MultipartFile file = rv.getRvFile();
			String filePath = "C:\\Users\\Administrator\\eclipse-workspace\\trip\\src\\main\\webapp\\resources\\reviewImg\\";
			rv.setRvPic(ip.fileUpload(file, filePath));
		}
		return rm.insertReview(rv);
	}

	@Override
	public Integer updateReview(ReviewVO rv) {
		return rm.updateReview(rv);
	}

	@Override
	public Integer avgSp(ReviewVO rv) {		
		return rm.avgSp(rv);
	}

	@Override
	public Integer deleteReview(ReviewVO rv) {
		return rm.deleteReview(rv);
	}
	
}
