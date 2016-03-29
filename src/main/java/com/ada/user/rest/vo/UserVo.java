package com.ada.user.rest.vo;

import java.io.Serializable;

/**
 * 用户简单信息
 * 
 * 
 * @author 年高
 *
 */
public class UserVo implements Serializable{
	/**
	 * 用户id
	 */
	private Long id;
	
	/**
	 * 用户名
	 */
	private String username;
	
	/**
	 * 用户名称
	 */
	private String name;

	
	/**
	 * 用户头像
	 */
	private String headimg;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getHeadimg() {
		return headimg;
	}


	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}
	
	

}
