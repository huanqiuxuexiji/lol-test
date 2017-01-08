package com.java2.web.Repository;

import java.sql.ResultSet;
import java.util.List;

import com.java2.web.Entity.NowUser;

public interface NowRepository {
	

	public NowUser addUser(NowUser nowUser);
	
	public List<NowUser> addAllUsers(List<NowUser> nowUsers);
	
	public NowUser findOneUser(long id);
	
	public ResultSet findAllUsers();
	
	public NowUser deleteUser(long id);
	
	public NowUser updateUser(long id, NowUser nowUser);

}
