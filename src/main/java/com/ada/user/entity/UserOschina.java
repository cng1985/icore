package com.ada.user.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.ada.data.entity.UUIDEntity;



@Entity
@Table(name = "user_login_oschina")
public class UserOschina extends UUIDEntity{
	
	
	/**
	 *用户email
	 */
	private String email;
	
	
	
	/**
	 *用户名
	 */
	private String name;
	
	
	/**
	 *性别
	 */
	private String gender;
	
	
	/**
	 *头像
	 */
	private String avatar;
	/**
	 * 地点
	 */
	private String location;
	/**
	 * 主页
	 */
	private String url;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	
	
	
}