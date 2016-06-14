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

/**
 * 用户
 * 
 * @author ada
 *
 */
@Entity
@Table(name = "user_info")
public class UserInfo extends AbstractEntity {

	public static UserInfo fromId(Long id) {
		UserInfo result = new UserInfo();
		result.setId(id);
		return result;
	}

	/** 属性 */
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "user_attribute")
	@MapKeyColumn(name = "name", length = 100)
	private Map<String, String> attributes = new HashMap<String, String>();
	/**
	 * 用户类型
	 */
	private Integer catalog;

	/**
	 * 点评数量
	 */
	private Integer comments;

	@Column(nullable = true)
	private String email;

	/**
	 * 朋友数量
	 */
	private Integer friends;

	/**
	 * 精英点评数量
	 */
	private Integer goods;

	private String headimg;

	private Integer logintimes;

	private String macaddress;
	private String name;
	private String password;

	private String phone;

	private String phonenum;

	@Transient
	private String plainPassword;

	/**
	 * 注册
	 */
	private String registerType = "账号";

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role_links")
	private Set<UserRole> roles = new HashSet<UserRole>();

	private String salt; // 加密密码的盐

	private String username;

	public Map<String, String> getAttributes() {
		return attributes;
	}

	public Integer getCatalog() {
		return catalog;
	}

	public Integer getComments() {
		return comments;
	}

	public String getCredentialsSalt() {
		return username + salt;
	}

	public String getEmail() {
		return email;
	}

	public Integer getFriends() {
		return friends;
	}

	public Integer getGoods() {
		return goods;
	}

	public String getHeadimg() {
		return headimg;
	}

	public Integer getLogintimes() {
		return logintimes;
	}

	public String getMacaddress() {
		return macaddress;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getPhone() {
		return phone;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public String getPlainPassword() {
		return plainPassword;
	}

	public String getRegisterType() {
		return registerType;
	}

	public Set<UserRole> getRoles() {
		return roles;
	}

	public String getSalt() {
		return salt;
	}

	public String getUsername() {
		return username;
	}

	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}

	public void setCatalog(Integer catalog) {
		this.catalog = catalog;
	}

	public void setComments(Integer comments) {
		this.comments = comments;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFriends(Integer friends) {
		this.friends = friends;
	}

	public void setGoods(Integer goods) {
		this.goods = goods;
	}

	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}

	public void setLogintimes(Integer logintimes) {
		this.logintimes = logintimes;
	}

	public void setMacaddress(String macaddress) {
		this.macaddress = macaddress;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public void setPlainPassword(String plainPassword) {
		this.plainPassword = plainPassword;
	}

	public void setRegisterType(String registerType) {
		this.registerType = registerType;
	}

	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
