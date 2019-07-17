package com.org.trip.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UserVO {

	private Integer userNum;
	private String userId;
	private String userPwd;
	private String userTel;
	private String userEmail;
	private String userGender;
	private String userBirth;
	private String userPic;
	private MultipartFile userFile;
	private String userNick;
	private String googleEmail;
	private String googleId;
	private String naverId;
	private String naverEmail;
}
