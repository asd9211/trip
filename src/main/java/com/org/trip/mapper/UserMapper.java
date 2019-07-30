package com.org.trip.mapper;

import java.util.List;

import com.org.trip.vo.UserVO;

public interface UserMapper {

	public List<UserVO>getUserList();
	public UserVO getUser(Integer userNum);
	public UserVO getUserByNick(UserVO user);
	public UserVO getLogin(UserVO user);
	public UserVO getUserBySns(UserVO user);
	public Integer insertUser(UserVO user);
	public Integer updateUser(UserVO user);
	public Integer deleteUser(UserVO user);
	public String getUserNick(Integer userNum);
}
