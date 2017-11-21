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

import com.quhaodian.data.entity.AbstractEntity;
import com.quhaodian.data.enums.State;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
	@CollectionTable(name = "user_info_attribute", joinColumns = { @JoinColumn(name = "user_id") })
	@MapKeyColumn(name = "name", length = 36)
	@Column(name = "attr", length = 100)
	private Map<String, String> attributes = new HashMap<String, String>();

	/**
	 * 用户头像
	 */
	private String avatar;

	/**
	 * 用户类型
	 */
	private Integer catalog;


	/**
	 * 手机号码
	 */
	@Column(length = 15)
	private String phone;

	/**
	 * 用户登录次数
	 */
	private Integer loginSize = 0;

	/**
	 * 用户真实姓名
	 */
	@Column(length = 20)
	private String name;

	/**
	 * 用户密码
	 */
	private String password;

	@Transient
	private String plainPassword;

	/**
	 * 注册
	 */
	@Column(length = 20)
	private String registerType = "账号";

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role_links", joinColumns = { @JoinColumn(name = "user_id") })
	private Set<UserRole> roles = new HashSet<UserRole>();

	/**
	 * 加密密码的盐
	 */
	private String salt;

	/**
	 * 用户状态
	 */
	@Enumerated()
	private State state;

	/**
	 * 用户名
	 */
	private String username;

	public Map<String, String> getAttributes() {
		return attributes;
	}

	public String getAvatar() {
		return avatar;
	}

	public Integer getCatalog() {
		if (catalog == null) {
			return 0;
		}
		return catalog;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
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

	public Integer getLoginSize() {
		return loginSize;
	}

	public void setLoginSize(Integer loginSize) {
		this.loginSize = loginSize;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public void setCatalog(Integer catalog) {
		this.catalog = catalog;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
