package com.org.trip.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.org.trip.croaling.HotelCroling;
import com.org.trip.mapper.HotelMapper;
import com.org.trip.service.HotelService;
import com.org.trip.vo.HotelVO;

@Service
public class HotelServiceImpl implements HotelService {

	@Resource
	private HotelMapper hm;
	@Resource
	private HotelCroling hc;
	@Override
	public List<HotelVO> getHotelList(String destination) {
		List<Map<String,String>> getHotelList = new ArrayList<Map<String,String>>();
		HotelVO hotel = new HotelVO();
		getHotelList=hc.searchHotel(destination);
		for(int i=0;i<getHotelList.size();i++) {
			for(int j=0;j<getHotelList.get(i).size();j++) {
				switch(i) {
				case 0:
				
				}
				getHotelList.get(i).get(j);
			}
		}
		return hm.getHotelList();
	}

	@Override
	public HotelVO getHotel(HotelVO hotel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insertHotel(HotelVO hotel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateHotel(HotelVO hotel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteHotel(HotelVO hotel) {
		// TODO Auto-generated method stub
		return null;
	}

}
