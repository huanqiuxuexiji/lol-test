package com.java2.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java2.web.dto.User;
import com.java2.web.repository.UserRepository;

@Service
public class UserServicelmp implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User getUser(long id){
		return userRepository.findOne(id);
	}

	public List<User> getAllUsers() {
		List<User> users = null;
		users = new ArrayList<User>();
		for(User user:userRepository.findAll()){
			User user1 = new User();
			user1.setId(user.getId());
			user1.setName(user.getName());
			user1.setAddress(user.getAddress());
			users.add(user);
		}
		return users;
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public List<User> createAllUser(List<User> users){
		return userRepository.saveall(users);
	}
	
	public User removeUser(long id){
		return userRepository.delete(id);
	}
	
	public User refreshUser(long id, User user){
		return userRepository.update(id, user);
	}


}
