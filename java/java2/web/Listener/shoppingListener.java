package com.java2.web.Listener;

import java.sql.ResultSet;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

import com.java2.web.Entity.NowUser;
import com.java2.web.Repository.NowRepository;
import com.java2.web.Repository.NowRepositorylmp;
import com.java2.web.Repository.UserRepository;
import com.java2.web.Repository.UserRepositorylmp;

public class shoppingListener implements ServletRequestListener, ServletContextListener{

	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		Timer timer = new Timer();  
        timer.schedule(new MyTask(), 0, 5000);
		
	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		
	}

	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		
	}

}

class MyTask extends TimerTask{
	public void run(){
		try{
			NowRepository nowUserRepository = new NowRepositorylmp();
			ResultSet rs = nowUserRepository.findAllUsers();
			
			UserRepository userRepository = new UserRepositorylmp();
			ResultSet rs2 = userRepository.findAllUsers();
			while(!rs.next()){
				NowUser nowUser = new NowUser();
				nowUser.setId(rs2.getInt("id"));
				nowUser.setNickName(rs2.getString("nickName"));
				nowUser.setPassword(rs2.getString("password"));
				nowUser.setEmail(rs2.getString("email"));
				nowUser.setSex(rs2.getString("sex"));
				
				nowUserRepository.addUser(nowUser);
			}
			while(rs.next()){
				if(System.currentTimeMillis() - rs.getLong("timeshopping") > 5*1000){
					while(rs2.next()){
						if(rs.getInt("id") != rs2.getInt("id")){
							if(!rs.getString("nickName").equals(rs2.getString("nickName"))){
								System.out.println(rs.getInt("id")+"用户的nickName发生了改变");
							}
						}
					}
					nowUserRepository.deleteUser(rs.getInt("id"));
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
