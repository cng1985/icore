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

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.ada.data.entity.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user_info")
public class UserInfo extends AbstractEntity {

	public static UserInfo fromId(Long id) {
		UserInfo result = new UserInfo();
		result.setId(id);
		return result;
	}


	private String age;

	@Column(length = 100)
	private String bgimg;

	private String city;

	/**
	 * 投资人所在公司
	 */
	private String company;
	private String email;
	private String headimg;


	private String introduction;

	private String job;

	private String exts;


	private Integer logintimes;

	private String macaddress;

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
	 * 用户密码
	 */
	@Basic(optional = false)
	@Column(length = 255)
	@JsonIgnore
	private String password;

	
	/**
	 * 电话号码
	 */
	private String phone;

	
	/**
	 * 传递时候的密码
	 */
	@Transient
	@JsonIgnore
	private String plainPassword;

	
	/**
	 * 腾讯qq号码
	 */
	private String qq;

	/**
	 * 用户角色
	 */
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role_links")
	private Set<UserRole> roles = new HashSet<UserRole>();

	/**
	 * 加密密码的盐
	 */
	@JsonIgnore
	private String salt;

	/** 属性 */
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "user_attribute")
	@MapKeyColumn(name = "name", length = 100)
	private Map<String, String> attributes = new HashMap<String, String>();

	/**
	 * 用户名
	 */
	@Column(unique = true)
	private String username;


	public String getAge() {
		return age;
	}

	public Map<String, String> getAttributes() {
		return attributes;
	}

	public String getBgimg() {
		return bgimg;
	}

	public String getCity() {
		return city;
	}

	public String getCompany() {
		return company;
	}

	@JsonIgnore
	@Transient
	public String getCredentialsSalt() {
		return username + salt;
	}

	public String getEmail() {
		return email;
	}

	public String getExts() {
		return exts;
	}

	public String getHeadimg() {
		return headimg;
	}


	public String getIntroduction() {
		return introduction;
	}

	public String getJob() {
		return job;
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

	/**
	 * Returns the password for this user.
	 *
	 * @return this user's password
	 */

	public String getPassword() {
		return password;
	}


	public String getPhone() {
		return phone;
	}

	public String getPlainPassword() {
		return plainPassword;
	}

	// 不持久化到数据库，也不显示在Restful接口的属性.

	public String getQq() {
		return qq;
	}

	public String getRealName() {
		return realName;
	}

	public Set<UserRole> getRoles() {
		if (roles == null) {
			roles = new HashSet<UserRole>();
		}
		return roles;
	}

	public String getSalt() {
		return salt;
	}

	/**
	 * Returns the username associated with this user account;
	 *
	 * @return the username associated with this user account;
	 */
	public String getUsername() {
		return username;
	}


	public void setAge(String age) {
		this.age = age;
	}

	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}

	public void setBgimg(String bgimg) {
		this.bgimg = bgimg;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setExts(String exts) {
		this.exts = exts;
	}

	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}


	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public void setJob(String job) {
		this.job = job;
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

	public void setPlainPassword(String plainPassword) {
		this.plainPassword = plainPassword;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public void setRealName(String realName) {
		this.realName = realName;
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

	@Override
	public String toString() {
		return "UserInfo [name=" + name + ", username=" + username + "]";
	}

}
