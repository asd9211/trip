package com.org.trip.mapper;

import java.util.List;

import com.org.trip.vo.HotelVO;

public interface HotelMapper {

	public List<HotelVO> getHotelList();
	public HotelVO getHotel(HotelVO hotel);
	public HotelVO getHotelByHotelName(HotelVO hotel);
	public Integer insertHotel(HotelVO hotel);
	public Integer updateHotel(HotelVO hotel);
	public Integer deleteHotel(HotelVO hotel);
}
