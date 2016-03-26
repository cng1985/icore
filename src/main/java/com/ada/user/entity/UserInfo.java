/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.ada.user.entity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.ada.data.entity.AbstractEntity;

@Entity
@Table(name = "user_info")
public class UserInfo extends AbstractEntity {

	public static UserInfo fromId(Long id) {
		UserInfo result = new UserInfo();
		result.setId(id);
		return result;
	}


	
	private String username;
	private String phone;

	private String name;
	/**
	 * 朋友数量
	 */
	private Integer friends;
	/**
	 * 点评数量
	 */
	private Integer comments;
	
	/**
	 * 精英点评数量
	 */
	private Integer goods;

	private String headimg;


	private String phonenum;


	@Column(nullable=true)
	private String email;


	private String password;


	private String macaddress;


	private Integer logintimes;


	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "users_role_links")
	private Set<UserRole> roles = new HashSet<UserRole>();



	private String salt; // 加密密码的盐
	@Transient
	private String plainPassword;

	/** 属性 */
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "user_attribute")
	@MapKeyColumn(name = "name", length = 100)
	private Map<String, String> attributes = new HashMap<String, String>();

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

	public Integer getFriends() {
		return friends;
	}

	public void setFriends(Integer friends) {
		this.friends = friends;
	}

	public Integer getComments() {
		return comments;
	}

	public void setComments(Integer comments) {
		this.comments = comments;
	}

	public Integer getGoods() {
		return goods;
	}

	public void setGoods(Integer goods) {
		this.goods = goods;
	}

	public String getHeadimg() {
		return headimg;
	}

	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
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

	public String getMacaddress() {
		return macaddress;
	}

	public void setMacaddress(String macaddress) {
		this.macaddress = macaddress;
	}

	public Integer getLogintimes() {
		return logintimes;
	}

	public void setLogintimes(Integer logintimes) {
		this.logintimes = logintimes;
	}

	public Set<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getPlainPassword() {
		return plainPassword;
	}

	public void setPlainPassword(String plainPassword) {
		this.plainPassword = plainPassword;
	}

	public Map<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	public String getCredentialsSalt() {
		return username + salt;
	}





	

}
