package com.org.trip.service;

import java.util.List;

import com.org.trip.vo.UserVO;

public interface UserService {

	public List<UserVO>getUserList();
	public UserVO getUser(Integer userNum);
	public UserVO getUserByNick(UserVO user);
	public UserVO getLogin(UserVO user);
	public UserVO getUserBySns(UserVO user);
	public Integer insertUser(UserVO user);
	public Integer updateUser(UserVO user);
	public Integer deleteUser(UserVO user);
}
