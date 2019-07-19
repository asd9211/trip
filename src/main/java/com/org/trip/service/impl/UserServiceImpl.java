package com.org.trip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.org.trip.mapper.UserMapper;
import com.org.trip.service.UserService;
import com.org.trip.util.SHAEncoder;
import com.org.trip.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper um;
	
	@Override
	public List<UserVO> getUserList() {
		return null;
	}

	@Override
	public UserVO getUser(Integer userNum) {
		return null;
	}

	@Override
	public UserVO getUserByName(String userName) {
		return null;
	}

	@Override
	public Integer insertUser(UserVO user) {
		user.setUserPwd(SHAEncoder.encode(user.getUserPwd()));
		return um.insertUser(user);
	}

	@Override
	public Integer updateUser(UserVO user) {
		if(user.getUserPwd()!=null) {
			user.setUserPwd(SHAEncoder.encode(user.getUserPwd()));
		}
		return um.updateUser(user);
	}

	@Override
	public Integer deleteUser(UserVO user) {
		return null;
	}

	@Override
	public UserVO getLogin(UserVO user) {
		user.setUserPwd(SHAEncoder.encode(user.getUserPwd()));
		return um.getLogin(user);
	}

	@Override
	public UserVO getUserBySns(UserVO user) {
		return um.getUserBySns(user);
	}

}
