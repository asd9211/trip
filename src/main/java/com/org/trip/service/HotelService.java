package com.org.trip.service;

import java.util.List;

import com.org.trip.vo.HotelVO;

public interface HotelService {
	public List<HotelVO> getHotelList(String destination);
	public List<HotelVO> getHotelByLowPrice(String destination);
	public List<HotelVO> getHotelByHighPrice(String destination);
	public HotelVO getHotel(HotelVO hotel);
	public Integer insertHotel(HotelVO hotel);
	public Integer updateHotel(HotelVO hotel);
	public Integer deleteHotel(HotelVO hotel);
}
