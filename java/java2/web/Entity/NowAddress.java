package com.java2.web.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "now_user_address")
public class NowAddress {
	@Id
	private long id;
	
	private String address;
	
	@Column(name = "is_default")
	private String isDefault;
	
	private String telphone;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)	
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private NowUser nowUser;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public NowUser getNowUser() {
		return nowUser;
	}

	public void setNowUser(NowUser nowUser) {
		this.nowUser = nowUser;
	}
	
	
	
}
