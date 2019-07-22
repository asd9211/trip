package com.org.trip.mapper;

import java.util.List;

import com.org.trip.vo.HotelVO;

public interface HotelMapper {

	public List<HotelVO> getHotelList();
	public List<HotelVO> getHotelByLowPrice(String destination);
	public List<HotelVO> getHotelByHighPrice(String destination);
	public HotelVO getHotel(HotelVO hotel);
	public List<HotelVO> getHotelByDestination(HotelVO hotel);	
	public Integer insertHotel(HotelVO hotel);
	public Integer updateHotel(HotelVO hotel);
	public Integer deleteHotel(HotelVO hotel);
}
