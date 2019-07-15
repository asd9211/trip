package com.org.trip.mapper;

import java.util.List;

import com.org.trip.vo.UserVO;

public interface UserMapper {

	public List<UserVO>getUserList();
	public UserVO getUser(Integer userNum);
	public UserVO getUserByName(String userName);
	public UserVO getLogin(UserVO user);
	public Integer insertUser(UserVO user);
	public Integer updateUser(UserVO user);
	public Integer deleteUser(UserVO user);
}
