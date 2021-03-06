package com.org.trip.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.trip.service.NoticeService;
import com.org.trip.vo.NoticeVO;

@RestController
@CrossOrigin("*")
public class NoticeController {

	@Resource
	private NoticeService ns;
	
	@GetMapping("/notices")
	public List<NoticeVO> getNoticeList(){
		return ns.getNoticeList();
	}
	@GetMapping("/notice/{nbNum}")
	public NoticeVO getNotice(@PathVariable Integer nbNum) {
		return ns.getNotice(nbNum);
	}
	@PostMapping("/notice")
	public Integer insertNotice(@RequestBody NoticeVO notice) {
		return ns.insertNotice(notice);
	}
}
