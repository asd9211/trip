package com.org.trip.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.trip.service.TipService;
import com.org.trip.vo.TipVO;

@CrossOrigin("*")
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
	@GetMapping("/tip/{userNum}")
	public List<TipVO> getTip(@PathVariable Integer userNum) {
		TipVO tip = new TipVO();
		tip.setUserNum(userNum);
		return ts.getTipByUserNum(tip);
	}
	@PostMapping("/tip")
	public Integer insertTip(@RequestBody TipVO tip) {
		return ts.insertTip(tip);
	}
	@PutMapping("/tip")
	public Integer updateTip(@RequestBody TipVO tip) {
		return ts.updateTip(tip);
	}
	@DeleteMapping("/tip")
	public Integer deleteTip(TipVO tip) {
		System.out.println("tip:"+tip);
		return ts.deleteTip(tip);
	}
}
