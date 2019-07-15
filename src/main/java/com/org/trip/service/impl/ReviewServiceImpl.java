package com.org.trip.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.org.trip.mapper.ReviewMapper;
import com.org.trip.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Resource
	private ReviewMapper rm;
	
	
}
