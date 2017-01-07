package com.java2.web.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.java2.web.entity.User;

@Repository
public class UserRepositorylmp implements UserRepository {
	
	@PersistenceContext
	EntityManager manager;

	public User addUser(User user) {
		manager.persist(user);
		return user;
	}

	public List<User> addAllUsers(List<User> users) {
		manager.persist(users);
		return users;
	}

	public User findOneUser(long id) {
		return manager.createQuery("from User where id=" + id, User.class).getSingleResult();
	}

	public List<User> findAllUsers() {
		return manager.createQuery("from User", User.class).getResultList();
	}

	public User deleteUser(long id) {
		User user = manager.find(User.class, id);
		manager.remove(user);
		return user;
	}

	public User updateUser(long id, User user1) {

		User user = manager.find(User.class, id);
		user.setId(user1.getId());
		user.setLoginName(user1.getLoginName());
		user.setNickName(user1.getNickName());
		user.setEmail(user1.getEmail());
		user.setPassword(user1.getPassword());
		manager.merge(user1);

		return user;
	}

	public User isUserCreditial(String userName, String password) {	
		return manager.createQuery("from User where loginName=" + userName, User.class).getSingleResult();
	}

}
