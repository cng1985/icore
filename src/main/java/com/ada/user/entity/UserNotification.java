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

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_notification")
public class UserNotification implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	/**
	 * 接收消息用户
	 */
	@JoinColumn(name = "userid")
	@ManyToOne()
	private UserInfo user;

	@JoinColumn(name = "catalogid")
	@ManyToOne()
	private UserNotificationCatalog catalog;

	private Date addDate;

	private Date lastDate;

	/**
	 * 发送数量
	 */
	private Integer nums;

	public Integer getNums() {
		return nums;
	}

	public void setNums(Integer nums) {
		this.nums = nums;
	}

	/**
	 * 通知内容
	 */
	private String note;

	/**
	 * 通知标题
	 */
	private String title;

	/**
	 * 用户
	 */
	@JoinColumn(name = "authorid")
	@ManyToOne()
	private UserInfo author;

	/**
	 * 分类<br/>
	 * 0为普通,普通的是发送个一个人的或者多个人 <br/>
	 * 1为全局，全局是给每个人发送
	 */
	private Integer category;

	/**
	 * 状态 1为已阅读 0为未阅读
	 */
	private Integer state;

	/**
	 * 来源id
	 */
	private Long fromid;

	public UserNotification() {
		addDate = new Date();
		lastDate = new Date();
	}

	public Date getAddDate() {
		return addDate;
	}

	public UserInfo getAuthor() {
		return author;
	}

	public Integer getCategory() {
		return category;
	}

	public Long getFromid() {
		return fromid;
	}

	public Long getId() {
		return id;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public String getNote() {
		return note;
	}

	public Integer getState() {
		return state;
	}

	public String getTitle() {
		return title;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public void setAuthor(UserInfo author) {
		this.author = author;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public void setFromid(Long fromid) {
		this.fromid = fromid;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public UserNotificationCatalog getCatalog() {
		return catalog;
	}

	public void setCatalog(UserNotificationCatalog catalog) {
		this.catalog = catalog;
	}

}
