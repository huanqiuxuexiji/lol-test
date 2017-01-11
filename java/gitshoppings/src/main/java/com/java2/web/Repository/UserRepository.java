package com.java2.web.Repository;

import java.util.List;

import com.java2.web.Entity.User;

public interface UserRepository {
	
	public User addUser(User user);
	
	public User findOneUser(long id);
	
	public List<User> findAllUsers();
	
	public User deleteUser(long id);
	
	public User updateUser(long id, User user);
	
}
