package com.org.trip.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.trip.service.AdminService;
import com.org.trip.service.UserService;
import com.org.trip.vo.AdminVO;
import com.org.trip.vo.UserVO;

@RestController
public class AdminController {

	   @Resource
	   private AdminService as;
	   
	   @GetMapping("/admins")
	   public List<AdminVO> getAdminList(){
	      return as.getAdminList();
	   }
}
