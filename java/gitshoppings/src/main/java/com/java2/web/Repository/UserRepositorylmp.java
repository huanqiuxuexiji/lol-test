package com.java2.web.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.java2.web.Entity.User;

@Repository
public class UserRepositorylmp implements UserRepository {
	
	@PersistenceContext
	EntityManager manager;

	public User addUser(User user) {
		manager.persist(user);
		return user;
	}


	public User findOneUser(long id) {
		return manager.createQuery("from User where id=" + id, User.class).getSingleResult();
	}

	public List<User> findAllUsers() {
		List<User> list = null;
		try{
			list = manager.createQuery("from User where isDefault = 'true'", User.class).getResultList();
		}catch(Exception e){
			System.out.println("wokaoUser");
		}
		return  list;
	}

	public User deleteUser(long id) {
		User user = manager.find(User.class, id);
		manager.remove(user);
		return user;
	}

	public User updateUser(long id, User user1) {

		User user = manager.find(User.class, id);
		user.setId(user1.getId());
		user.setSex(user1.getSex());
		user.setNickName(user1.getNickName());
		user.setEmail(user1.getEmail());
		user.setPassword(user1.getPassword());
		user.setAddresses(user1.getAddresses());
		manager.merge(user1);

		return user;
	}

}
