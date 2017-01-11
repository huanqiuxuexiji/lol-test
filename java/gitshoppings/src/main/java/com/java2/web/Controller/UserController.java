package com.java2.web.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java2.web.Dto.UserDto;
import com.java2.web.Service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController{
	@Autowired
	private UserService userService;
		
	//查找单个
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public UserDto getUser(@PathVariable() long id){
		return userService.getUser(id);
	}
	
	//查找多个
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public List<UserDto> getAllUser() {
		return userService.getAllUsers();
	}
	
	//创建
	@RequestMapping(path = "/", method = RequestMethod.POST)
	public UserDto createUser(@RequestBody UserDto userDto) {
		return userService.createUser(userDto);
	}
	
	//删除
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public UserDto removeUser(@PathVariable() long id){
		return userService.removeUser(id);
	}
	
	//更改
	@RequestMapping(path = "/{id}", method = RequestMethod.PATCH)
	public UserDto refreshUser(@PathVariable() long id, @RequestBody UserDto user){
		return userService.refreshUser(id, user);
	}
}
