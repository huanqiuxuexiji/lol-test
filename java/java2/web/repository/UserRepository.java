package com.java2.web.repository;

import java.util.List;

import com.java2.web.entity.User;

public interface UserRepository {
	
	public User addUser(User user);
	
	public List<User> addAllUsers(List<User> users);
	
	public User findOneUser(long id);
	
	public List<User> findAllUsers();
	
	public User deleteUser(long id);
	
	public User updateUser(long id, User user);

	public User isUserCreditial(String userName, String password);
}
