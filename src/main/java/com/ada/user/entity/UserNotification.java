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

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ada.data.entity.AbstractEntity;



/**
 * 用户通知
 * 
 * @author ada
 *
 */
@Entity
@Table(name = "user_notification")
public class UserNotification extends AbstractEntity {

	/**
	 * 用户
	 */
	@JoinColumn(name = "authorid")
	@ManyToOne()
	private UserInfo author;

	@JoinColumn(name = "catalogid")
	@ManyToOne()
	private UserNotificationCatalog catalog;

	/**
	 * 分类<br/>
	 * 0为普通,普通的是发送个一个人的或者多个人 <br/>
	 * 1为全局，全局是给每个人发送
	 */
	private Integer category;

	/**
	 * 封面
	 */
	private String image;

	private String introduction;

	/**
	 * 通知内容
	 */
	private String note;

	/**
	 * 发送数量
	 */
	private Integer nums;

	/**
	 * 通知标题
	 */
	private String title;

	/**
	 * 点击次数
	 */
	private Integer clicks;

	/**
	 * 跳转url
	 */
	private String url;

	/**
	 * 是否置顶 1为置顶 0为非置顶
	 */
	private Integer top;

	/**
	 * 分类1置顶2推荐3跳转
	 */
	private Integer taxonomy;

	public Integer getClicks() {
		return clicks;
	}

	public void setClicks(Integer clicks) {
		this.clicks = clicks;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getTop() {
		return top;
	}

	public void setTop(Integer top) {
		this.top = top;
	}

	public Integer getTaxonomy() {
		return taxonomy;
	}

	public void setTaxonomy(Integer taxonomy) {
		this.taxonomy = taxonomy;
	}

	public UserInfo getAuthor() {
		return author;
	}

	public UserNotificationCatalog getCatalog() {
		return catalog;
	}

	public Integer getCategory() {
		return category;
	}

	public String getImage() {
		return image;
	}

	public String getIntroduction() {
		return introduction;
	}

	public String getNote() {
		return note;
	}

	public Integer getNums() {
		return nums;
	}

	public String getTitle() {
		return title;
	}

	public void setAuthor(UserInfo author) {
		this.author = author;
	}

	public void setCatalog(UserNotificationCatalog catalog) {
		this.catalog = catalog;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public void setNums(Integer nums) {
		this.nums = nums;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
