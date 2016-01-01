package com.ada.user.dto;

import javax.persistence.Column;

import com.ada.data.dto.BaseDto;

public class UserDto extends BaseDto{
	
	/**
	 * 用户昵称
	 */
	private String name;
	
	/**
	 * 用户真实名
	 */
	@Column(name="realname")
	private String realName;
	
	/**
	 * 电话号码
	 */
	private String phone;

	
	/**
	 * 用户名
	 */
	@Column(unique = true)
	private String username;
	
	
	private String email;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getRealName() {
		return realName;
	}


	public void setRealName(String realName) {
		this.realName = realName;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


}
