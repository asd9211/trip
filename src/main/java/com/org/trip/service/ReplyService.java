package com.org.trip.service;

import java.util.List;

import com.org.trip.vo.ReplyVO;

public interface ReplyService {
	public List<ReplyVO> getReplyList();
	public ReplyVO getReplyByUser(ReplyVO re);
	public Integer insertReply(ReplyVO re);
	public Integer updateReply(ReplyVO re);
	public Integer deleteReply(ReplyVO re);
}
