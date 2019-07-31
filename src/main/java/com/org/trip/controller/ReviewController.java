package com.org.trip.controller;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.org.trip.service.ReviewService;
import com.org.trip.util.InsertPic;
import com.org.trip.vo.ReviewVO;

@CrossOrigin("*")
@RestController
public class ReviewController {
	final String BASE_URL = "C:\\Users\\Administrator\\eclipse-workspace\\trip\\src\\main\\webapp\\resources\\reviewImg";
	@Resource
	private ReviewService rs;
	@Resource
	private InsertPic ip;
	
	@GetMapping("/reviews")
	public List<ReviewVO> getReviewList() {
		return rs.getReviewList();
	}
	@GetMapping("/review")
	public ReviewVO getReview(ReviewVO rv) {
		return rs.getReview(rv);
	}
	@GetMapping("/review/{userNum}")
	public List<ReviewVO> getReviewByUser(@PathVariable("userNum") Integer userNum) {
		ReviewVO rv = new ReviewVO();
		rv.setUserNum(userNum);
		return rs.getReviewByUser(rv);
	}
	@PostMapping("/review")
	public Integer insertReview(@RequestBody ReviewVO rv) {
		return rs.insertReview(rv);
	}
	@PutMapping("/review")
	public Integer updateReview(@RequestBody ReviewVO rv) {
		return rs.updateReview(rv);
	}
	//별점은내일
	@DeleteMapping("/review")
	public Integer deleteReview(ReviewVO rv) {
		return rs.deleteReview(rv);
	}
	@PutMapping("/reviewLike")
	public Integer likeUp(@RequestBody ReviewVO rv) {
		return rs.likeUp(rv);
	}
	@PostMapping("/upload/one")
	public Map<String, Object> upload(MultipartFile upload) throws IllegalStateException, IOException{
		String reName = ip.fileUpload(upload, BASE_URL + File.separator);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("url", "http://localhost:88/image?name="+reName); //not null
		map.put("uploaded", 1); // allow null
		map.put("uploadedPercent", 1); // allow null
		map.put("error", "error"); // allow null
		return map;
	}
	
	@GetMapping("/image")
	public ResponseEntity<byte[]> image(@RequestParam(value="name") String name) throws IOException{
		File file = new File(BASE_URL + File.separator + name);
		FileInputStream in = new FileInputStream(file);
		byte[] buffer = new byte[in.available()];
		in.read(buffer);
		in.close();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);
		return new ResponseEntity<byte[]>(buffer, headers, HttpStatus.OK);
	}
}
