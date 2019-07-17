package com.org.trip.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RestController;

import com.org.trip.service.WithService;
import com.org.trip.vo.WithVO;

@RestController
public class WithController {

	@Resource
	private WithService ws;
	
	public List<WithVO> getWithList(){
		return ws.getWithList();
	}
	public WithVO getWith(WithVO with) {
		return ws.getWith(with);
	}
	public Integer insertWith(WithVO with) {
		return ws.insertWith(with);
	}
	public Integer updateWith(WithVO with) {
		return ws.updateWith(with);
	}
	public Integer deleteWith(WithVO with) {
		return ws.deleteWith(with);
	}
}
