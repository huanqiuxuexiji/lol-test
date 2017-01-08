package com.java2.web.Repository;

import java.sql.ResultSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.java2.web.Entity.NowUser;
import com.java2.web.Entity.User;


public class NowRepositorylmp implements NowRepository {
	
	@PersistenceContext
	EntityManager manager;

	public NowUser addUser(NowUser nowUser) {
		manager.persist(nowUser);
		return nowUser;
	}

	public List<NowUser> addAllUsers(List<NowUser> nowUsers) {
		manager.persist(nowUsers);
		return nowUsers;
	}

	public NowUser findOneUser(long id) {
		return manager.createQuery("from NowUser where id=" + id, NowUser.class).getSingleResult();
	}

	public ResultSet findAllUsers() {
		return (ResultSet) manager.createQuery("from User", User.class).getResultList();
	}

	public NowUser deleteUser(long id) {
		NowUser nowUser = manager.find(NowUser.class, id);
		manager.remove(nowUser);
		return nowUser;
	}

	public NowUser updateUser(long id, NowUser nowUser1) {
		NowUser nowUser = manager.find(NowUser.class, id);
		nowUser.setId(nowUser1.getId());
		nowUser.setSex(nowUser1.getSex());
		nowUser.setNickName(nowUser1.getNickName());
		nowUser.setEmail(nowUser1.getEmail());
		nowUser.setPassword(nowUser1.getPassword());
		manager.merge(nowUser1);
		return nowUser;
		
	}

}
