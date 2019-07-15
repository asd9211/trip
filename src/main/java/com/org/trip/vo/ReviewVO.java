package com.org.trip.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ReviewVO {

	private Integer rvNum;
	private Integer rvLike;
	private String rvDate;
	private String rvPic;
	private MultipartFile rvFile;
	private String rvContent;
	private Integer rvCnt;
	private Integer rvSp;
	private String rvCost;
	private String rvTitle;
	private Integer userNum;
}
