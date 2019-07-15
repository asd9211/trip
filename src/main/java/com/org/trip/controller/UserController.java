package com.org.trip.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.trip.service.UserService;
import com.org.trip.vo.UserVO;

@RestController
public class UserController {
	@Resource
	private UserService us;
	
	@PostMapping("/user")
	public Integer insertUser(@RequestBody UserVO user) {
		return us.insertUser(user);
	}
	
}
