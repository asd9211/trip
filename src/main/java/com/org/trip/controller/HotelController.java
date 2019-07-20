package com.org.trip.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.org.trip.service.HotelService;
import com.org.trip.vo.HotelVO;

@RestController
public class HotelController {

	@Resource
	private HotelService hs;
	@GetMapping("/hotel/{destination}")
	public List<HotelVO> getHotelList(@PathVariable String destination){
		return hs.getHotelList(destination);
	}
}
