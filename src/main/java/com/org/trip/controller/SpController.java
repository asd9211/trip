package com.org.trip.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.trip.service.SpService;
import com.org.trip.vo.SpVO;

@RestController
public class SpController {

	@Resource
	private SpService sps;
	
	@PostMapping("/sp")
	public Integer insertSp(SpVO sp) {
		return sps.insertSp(sp);
	}
	@DeleteMapping("/sp")
	public Integer deleteSp(SpVO sp) {
		return sps.deleteSp(sp);
	}
}
