package com.java2.web.Service;

import java.util.List;

import com.java2.web.Dto.UserDto;

public interface UserService {

	UserDto getUser(long id);

	List<UserDto> getAllUsers();

	UserDto removeUser(long id);

	UserDto createUser(UserDto user);

	UserDto refreshUser(long id, UserDto user);
	
}
