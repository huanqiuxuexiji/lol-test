package com.java2.web.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.java2.web.dto.User;


@Repository
@Transactional
public class UserRepositorylmp implements UserRepository{
	
	@PersistenceContext
	EntityManager manager;
	
	public User save(User user){			
		manager.persist(user);				
		return user;
	}
	
	
	public List<User> saveall(List<User> users){	
		manager.persist(users);				
		return users;
	}
	
	public User findOne(long id){
		User user = manager.find(User.class, id);
		return user;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> findAll(){
		return manager.createQuery("from User").getResultList();
	}
	
	public User delete(long id){
		User user = manager.find(User.class, id);		
		manager.remove(user);
		
		return user;
	}
	
	public User update(long id, User user){
		User user1 = manager.find(User.class, id);
		user1.setId(user.getId());
		user1.setName(user.getName());
		user1.setAddress(user.getAddress());
		manager.merge(user1);
		
		return user1;
	}
}
