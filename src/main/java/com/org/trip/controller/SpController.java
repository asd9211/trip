package com.org.trip.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.trip.service.SpService;
import com.org.trip.vo.SpVO;

@RestController
@CrossOrigin("*")
public class SpController {

	@Resource
	private SpService sps;
	
	@PostMapping("/sp")
	public Integer insertSp(@RequestBody SpVO sp) {
		return sps.insertSp(sp);
	}
	@DeleteMapping("/sp")
	public Integer deleteSp(@RequestBody SpVO sp) {
		return sps.deleteSp(sp);
	}
}
