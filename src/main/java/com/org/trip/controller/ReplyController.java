package com.org.trip.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.trip.service.ReplyService;
import com.org.trip.vo.ReplyVO;

@CrossOrigin("*")
@RestController
public class ReplyController {

	@Resource
	private ReplyService rs;
	
	@GetMapping("/replys")
	public List<ReplyVO> getReplyList(){
		return rs.getReplyList();
	}
	@PostMapping("/replybyboard")
	public List<ReplyVO> getReplyByUser(@RequestBody ReplyVO re) {
		System.out.println(re);
		return rs.getReply(re);
	}
	@PostMapping("/reply")
	public Integer insertReply(@RequestBody ReplyVO re) {
		return rs.insertReply(re);
	}
	
	
	@PutMapping("/reply")
	public Integer updateReply(ReplyVO re) {
		return rs.updateReply(re);
	}
	@DeleteMapping("/reply")
	public Integer deleteReply(ReplyVO re) {
		return rs.deleteReply(re);
	}
}
