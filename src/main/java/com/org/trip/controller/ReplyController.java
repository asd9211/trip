package com.org.trip.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.trip.service.ReplyService;
import com.org.trip.vo.ReplyVO;

@RestController
public class ReplyController {

	@Resource
	private ReplyService rs;
	
	@GetMapping("/replys")
	public List<ReplyVO> getReplyList(){
		return rs.getReplyList();
	}
	@GetMapping("/reply")
	public ReplyVO getReplyByUser(ReplyVO re) {
		return rs.getReplyByUser(re);
	}
	@PostMapping("/reply")
	public Integer insertReply(ReplyVO re) {
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
