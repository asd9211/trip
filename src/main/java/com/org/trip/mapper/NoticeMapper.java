package com.org.trip.mapper;

import java.util.List;

import com.org.trip.vo.NoticeVO;

public interface NoticeMapper {
	
	public List<NoticeVO> getNoticeList();
	public NoticeVO getNotice(Integer nbNum);
	public Integer insertNotice(NoticeVO notice);
}
