package com.java2.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.java2.web.entity.User;
import com.java2.web.service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController{
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(path = "/find", method = RequestMethod.GET)
	@ResponseBody
	public User getUser(@RequestParam long id){
		return userService.getUser(id);
	}

	@RequestMapping(path = "/findall", method = RequestMethod.GET)
	@ResponseBody
	public List<User> getAllUser() {
		return userService.getAllUsers();
	}

	@RequestMapping(path = "/save", method = RequestMethod.POST)
	@ResponseBody
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	@RequestMapping(path = "/saveall", method = RequestMethod.POST)
	@ResponseBody
	public List<User> createAllUser(@RequestBody List<User> users){
		return userService.createAllUsers(users);
	}
	
	@RequestMapping(path = "/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public User removeUser(@RequestParam long id){
		return userService.removeUser(id);
	}
	
	@RequestMapping(path = "/update", method = RequestMethod.PATCH)
	@ResponseBody
	public User refreshUser(@RequestParam long id, @RequestBody User user){
		return userService.refreshUser(id, user);
	}
}
