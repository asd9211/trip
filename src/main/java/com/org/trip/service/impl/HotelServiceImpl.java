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
		HotelVO hotel = new HotelVO();
		hotel.setHotelDestination(destination);
		if(hm.getHotelByDestination(hotel)==null) {
			List<Map<String,String>> getHotelList = new ArrayList<Map<String,String>>();
			getHotelList=hc.searchHotel(destination);		
			for(int i=0; i<getHotelList.size();i++) {			
				hotel.setHotelPrice(getHotelList.get(i).get("hotelPrice"));
				hotel.setHotelName(getHotelList.get(i).get("hotelName"));
				hotel.setHotelAddr(getHotelList.get(i).get("hotelAddress"));
				hm.insertHotel(hotel);
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

	@Override
	public List<HotelVO> getHotelByLowPrice(String destination) {
		return hm.getHotelByLowPrice(destination);
	}

	@Override
	public List<HotelVO> getHotelByHighPrice(String destination) {
		return hm.getHotelByHighPrice(destination);
	}

}
