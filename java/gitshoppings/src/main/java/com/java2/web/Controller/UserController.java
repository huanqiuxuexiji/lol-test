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
		
	//���ҵ���
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public UserDto getUser(@PathVariable() long id){
		return userService.getUser(id);
	}
	
	//���Ҷ��
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public List<UserDto> getAllUser() {
		return userService.getAllUsers();
	}
	
	//����
	@RequestMapping(path = "/", method = RequestMethod.POST)
	public UserDto createUser(@RequestBody UserDto userDto) {
		return userService.createUser(userDto);
	}
	
	//ɾ��
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public UserDto removeUser(@PathVariable() long id){
		return userService.removeUser(id);
	}
	
	//����
	@RequestMapping(path = "/{id}", method = RequestMethod.PATCH)
	public UserDto refreshUser(@PathVariable() long id, @RequestBody UserDto user){
		return userService.refreshUser(id, user);
	}
}
