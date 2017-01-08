package com.java2.web.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "now_user")
public class NowUser {
	@Id
	private long id;
	
	@Column(name = "nick_name")
	private String nickName;
	
	private String email;
	
	private String password;
	
	private String sex;
	
	@OneToMany(mappedBy="nowUser", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<NowAddress> nowAddresses;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public List<NowAddress> getNowAddresses() {
		return nowAddresses;
	}

	public void setNowAddresses(List<NowAddress> nowAddresses) {
		this.nowAddresses = nowAddresses;
	}
	
	
}
