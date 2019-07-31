package com.org.trip.croaling;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

@Component
public class HotelCroling {
	public List<Map<String,String>> searchHotel(String destination) {
		List<Map<String,String>> getHotelList = new ArrayList<Map<String,String>>();
		Map<String,String> priceMap = new HashMap<String,String>();
		Map<String,String> hotelNameMap = new HashMap<String,String>();
		Map<String,String> hotelAddressMap = new HashMap<String,String>();
		Map<String,String> hotelPicMap = new HashMap<String,String>();
		String hotelUrl = "https://kr.hotels.com";
		String sort="PRICE";
		//체크인,체크아웃기능
//		String qcheckin="";
//		String qcheckout="";
		int page=1;
		int priceNum=1;
		int nameNum=1;
		int addressNum=1;
		int hotelPicNum=1;
		try {
			while(true) {
				Document doc = Jsoup.connect(hotelUrl+"/search.do?q-destination="+destination+"&sort-order="+sort+"&pn="+page).get();
				Elements pictureUrl = doc.select(".image img");
				Elements price = doc.select(".price");//ins
				Elements hotelName = doc.select(".hotel-wrap .p-name");
				Elements hotelAddress = doc.select(".address");
				if(price.size()==0) {
					break;
				}
				
				for(Element e : pictureUrl) {
					String paramPic = e.toString();
					if(paramPic.indexOf(("featured-img-desktop"))!=-1) {
						paramPic = paramPic.substring(paramPic.lastIndexOf("https:"), paramPic.lastIndexOf("\')"));
						URL u = new URL(paramPic);
						String fileUrl = "C:\\Users\\Administrator\\eclipse-workspace\\trip\\src\\main\\webapp\\resources\\hotelImg\\";
						String fileName = String.valueOf(System.currentTimeMillis())+".png";
						hotelPicMap.put("hotelPic"+hotelPicNum, "/img/"+fileName);
						hotelPicNum++;
						FileOutputStream fos = new FileOutputStream(fileUrl+fileName);
						InputStream is = u.openStream();
						byte[] buf = new byte[1024];
						int len=0;
						while((len=is.read(buf))>0) {
							fos.write(buf,0,len);
						}
						fos.close();
						is.close();
					}					
				}
				
				for(Element e: price) {					
					int begin = e.text().lastIndexOf("₩");
					int end = e.text().lastIndexOf("다음");
					String hotelPrice = "";
					if(end==-1) {
						hotelPrice = e.text().substring(begin);
					}else {
						hotelPrice = e.text().substring(begin,end);						
					}
					priceMap.put("hotelPrice"+priceNum, hotelPrice);
					priceNum++;
				}
				for(Element e:hotelName) {			
					hotelNameMap.put("hotelName"+nameNum, e.text());
					nameNum++;
				}
				for(Element e:hotelAddress) {				
					hotelAddressMap.put("hotelAddress"+addressNum, e.text());
					addressNum++;
				}
				page++;
			}
			for(int i=1;i<=priceMap.size();i++) {
				Map<String,String> pMap = new HashMap<String,String>();
				pMap.put("hotelPrice",priceMap.get("hotelPrice"+i));
				pMap.put("hotelName",hotelNameMap.get("hotelName"+i));
				pMap.put("hotelAddress",hotelAddressMap.get("hotelAddress"+i));
				pMap.put("hotelPic", hotelPicMap.get("hotelPic"+i));
				getHotelList.add(pMap);
			}
			return getHotelList;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}