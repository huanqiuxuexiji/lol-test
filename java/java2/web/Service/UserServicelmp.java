package com.java2.web.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java2.web.Entity.User;
import com.java2.web.Repository.UserRepository;

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
		ResultSet rs = userRepository.findAllUsers();
		try {
			while(rs.next()){
				User user1 = new User();
				user1.setId(rs.getInt("id"));
				user1.setSex(rs.getString("sex"));
				user1.setNickName(rs.getString("nickName"));
				user1.setEmail(rs.getString("email"));
				user1.setPassword(rs.getString("password"));
				user1.setAddresses((List)rs.getArray("addresses"));		
				users.add(user1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

}
