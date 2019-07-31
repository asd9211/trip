package com.org.trip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.org.trip.mapper.ReplyMapper;
import com.org.trip.service.ReplyService;
import com.org.trip.vo.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService {

   @Resource
   private ReplyMapper rm;
   
   @Override
   public List<ReplyVO> getReplyList() {
      return rm.getReplyList();
   }

   @Override
   public ReplyVO getReplyByUser(ReplyVO re) {
      return rm.getReplyByUser(re);
   }
      

   @Override
   public Integer insertReply(ReplyVO re) {
      return rm.insertReply(re);
   }

   @Override
   public Integer updateReply(ReplyVO re) {
      return rm.updateReply(re);
   }

   @Override
   public Integer deleteReply(ReplyVO re) {
      return rm.deleteReply(re);
   }

   @Override
   public List<ReplyVO> getReply(ReplyVO re) {      
      return rm.getReply(re);
   }

}