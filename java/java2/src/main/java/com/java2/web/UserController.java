package com.java2.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.java2.web.dto.User;
import com.java2.web.service.UserService;

@RestController
@RequestMapping(path = "/userser")
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	@ResponseBody
	public User getUser(@RequestParam long id){
		return userService.getUser(id);
	}

	@RequestMapping(value = "/findall", method = RequestMethod.GET)
	@ResponseBody
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	@RequestMapping(value = "/saveall", method = RequestMethod.POST)
	@ResponseBody
	public List<User> createAllUser(@RequestBody List<User> users){
		return userService.createAllUser(users);
	}
}
