package com.org.trip.croaling;

import java.io.IOException;
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
		String hotelUrl = "https://kr.hotels.com";
		String sort="PRICE";
		//체크인,체크아웃기능
//		String qcheckin="";
//		String qcheckout="";
		int page=1;
		int priceNum=1;
		int nameNum=1;
		int addressNum=1;
		try {
			while(true) {
				Document doc = Jsoup.connect(hotelUrl+"/search.do?q-destination="+destination+"&sort-order="+sort+"&pn="+page).get();
				//페이지보기위해서 만들었음
//				Response res = (Response) Jsoup.connect("https://kr.hotels.com/search.do?q-destination="+destination+"&sort-order="+sort+"&pn="+page).execute();
//				System.out.println(res.url());
				Elements pictureUrl = doc.select(".property-name-link");
				Elements price = doc.select(".price");//ins
				Elements hotelName = doc.select(".hotel-wrap .p-name");
				Elements hotelAddress = doc.select(".address");
				if(price.size()==0) {
					break;
				}
//				for(Element e : pictureUrl) {
//					String str = e.toString();
//					int a = str.indexOf("\"")+1;
//					str = str.substring(a);
//					a = str.indexOf("\"");
//					str = str.substring(0, a);
//					str = hotelUrl + str;
//					System.out.println(str);
//					doc = Jsoup.connect(str).get();
//					Elements pictures = doc.select("#carousel-container .image");
//					for(Element p : pictures) {
//						System.out.println(p.dataset().get("desktop"));
//						str=p.dataset().get("desktop");
//						URL u = new URL(str);
//						String fileUrl = "D:\\study\\sp\\src\\main\\webapp\\resources\\hotelImg\\";
//						String fileName = String.valueOf(System.currentTimeMillis())+".png";
//						FileOutputStream fos = new FileOutputStream(fileUrl+fileName);
//						InputStream is = u.openStream();
//						byte[] buf = new byte[1024];
//						int len=0;
//						while((len=is.read(buf))>0) {
//							fos.write(buf,0,len);
//						}
//						fos.close();
//						is.close();
//					}
//					}
				
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
				getHotelList.add(pMap);
			}
			System.out.println(getHotelList);
			return getHotelList;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}