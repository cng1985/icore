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

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import com.ada.data.entity.AbstractEntity;

/**
 * 用户角色
 */
@Entity
@Table(name = "user_role")
public class UserRole extends AbstractEntity {

	/**
	 * 角色名
	 */
	@Basic(optional = false)
	@Column(length = 100)
	private String name;
	/**
	 * 角色描述
	 */
	@Column(length = 255)
	private String description;
	
	/** 是否内置 */
	private Boolean isSystem;


	/** 权限 */
	@ElementCollection(fetch=FetchType.LAZY)
	@CollectionTable(name = "user_role_authority")
	private List<String> authorities = new ArrayList<String>();

	public UserRole() {
	}

	public UserRole(String name) {
		this.name = name;
	}

	public Boolean getIsSystem() {
		return isSystem;
	}

	public void setIsSystem(Boolean isSystem) {
		this.isSystem = isSystem;
	}

	public List<String> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<String> authorities) {
		this.authorities = authorities;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}
