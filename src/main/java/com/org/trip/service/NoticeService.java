package com.org.trip.service;

import java.util.List;

import com.org.trip.vo.NoticeVO;

public interface NoticeService {
	public List<NoticeVO> getNoticeList();
	public NoticeVO getNotice(Integer nbNum);
	public Integer insertNotice(NoticeVO notice);
}
