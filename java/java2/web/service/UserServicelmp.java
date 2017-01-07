package com.java2.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java2.web.entity.User;
import com.java2.web.repository.UserRepository;

@Service
@Transactional
public class UserServicelmp implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	
	public User getUser(long id) {
		return userRepository.findOneUser(id);
	}

	public List<User> getAllUsers() {
		List<User> users = null;
		users = new ArrayList<User>();
		for(User user:userRepository.findAllUsers()){
			User user1 = new User();
			user1.setId(user.getId());
			user1.setLoginName(user.getLoginName());
			user1.setNickName(user.getNickName());
			user1.setEmail(user.getEmail());
			user1.setPassword(user.getPassword());
			user1.setAddresses(user.getAddresses());
			user1.setOrderList(user.getOrderList());		
			users.add(user);
		}
		return users;
	}

	public List<User> createAllUsers(List<User> users) {
		return userRepository.addAllUsers(users);
	}

	public User removeUser(long id) {
		return userRepository.deleteUser(id);
	}

	public User createUser(User user) {
		return userRepository.addUser(user);
	}

	public User refreshUser(long id, User user) {
		return userRepository.updateUser(id, user);
	}
	
	public boolean isUserCreditial(String userName, String password){
		User user = userRepository.isUserCreditial(userName, password);
		System.out.println(user.getPassword());
		if(user.getPassword() == password){
			return true;
		}
		
		return false;
	}

}
