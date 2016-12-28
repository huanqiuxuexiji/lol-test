package com.java2.web.repository;

import java.util.List;

import com.java2.web.dto.User;

public interface UserRepository {
	
	public User save(User user);
	
	public List<User> saveall(List<User> users);
	
	public User findOne(long id);
	
	public List<User> findAll();
	
	public User delete(long id);
	
	public User update(long id, User user);

}
