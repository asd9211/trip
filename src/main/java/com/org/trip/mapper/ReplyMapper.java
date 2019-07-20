package com.org.trip.mapper;

import java.util.List;

import com.org.trip.vo.ReplyVO;

public interface ReplyMapper {

   public List<ReplyVO> getReplyList();
   public List<ReplyVO> getReply(ReplyVO re);
   public ReplyVO getReplyByUser(ReplyVO re);
   public Integer insertReply(ReplyVO re);
   public Integer updateReply(ReplyVO re);
   public Integer deleteReply(ReplyVO re);
}