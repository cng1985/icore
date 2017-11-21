package com.ada.user.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.quhaodian.data.entity.BaseEntity;



@Entity
@Table(name = "user_oauth_info_oschina")
public class UserOschina extends BaseEntity{
	
	
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="userid")
	private UserInfo user;
	
	
	public UserInfo getUser() {
		return user;
	}
	public void setUser(UserInfo user) {
		this.user = user;
	}
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
