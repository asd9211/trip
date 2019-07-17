package com.org.trip.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.trip.service.TipService;
import com.org.trip.vo.TipVO;

@RestController
public class TipController {
	
	@Resource
	private TipService ts;
	
	@GetMapping("/tips")
	public List<TipVO> getTipList(){
		return ts.getTipList();
	}
	@GetMapping("/tip")
	public TipVO getTip(TipVO tip) {
		return ts.getTip(tip);
	}
	@PostMapping("/tip")
	public Integer insertTip(TipVO tip) {
		return ts.insertTip(tip);
	}
	@PutMapping("/tip")
	public Integer updateTip(TipVO tip) {
		return ts.updateTip(tip);
	}
	@DeleteMapping("/tip")
	public Integer deleteTip(TipVO tip) {
		return ts.deleteTip(tip);
	}
}
