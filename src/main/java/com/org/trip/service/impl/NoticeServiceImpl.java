package com.org.trip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.org.trip.mapper.NoticeMapper;
import com.org.trip.service.NoticeService;
import com.org.trip.vo.NoticeVO;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Resource
	private NoticeMapper nm;
	
	@Override
	public List<NoticeVO> getNoticeList() {
		return nm.getNoticeList();
	}

	@Override
	public NoticeVO getNotice(Integer nbNum) {
		return nm.getNotice(nbNum);
	}

	@Override
	public Integer insertNotice(NoticeVO notice) {
		return nm.insertNotice(notice);
	}

}
