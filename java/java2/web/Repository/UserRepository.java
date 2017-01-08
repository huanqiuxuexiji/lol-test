package com.java2.web.Repository;

import java.sql.ResultSet;
import java.util.List;

import com.java2.web.Entity.User;

public interface UserRepository {
	
	public User addUser(User user);
	
	public List<User> addAllUsers(List<User> users);
	
	public User findOneUser(long id);
	
	public ResultSet findAllUsers();
	
	public User deleteUser(long id);
	
	public User updateUser(long id, User user);

}
