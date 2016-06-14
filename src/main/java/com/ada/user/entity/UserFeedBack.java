package com.ada.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ada.data.entity.AbstractEntity;

/**
 * 用户意见反馈
 * 
 * @author aniaojian
 *
 */

@Entity
@Table(name = "user_feedback")
public class UserFeedBack extends AbstractEntity {

	/**
	 * 反感标题
	 */
	@Column(length = 100)
	private String title;

	/**
	 * 反感内容
	 */
	@Column(length = 5000)
	private String contents;

	/**
	 * 扩展信息
	 */
	@Column(length = 5000)
	private String exts;

	/**
	 * 反馈系统中的用户
	 */
	@JoinColumn(name = "userid")
	@ManyToOne(fetch = FetchType.LAZY)
	private UserInfo user;

	/**
	 * 反馈人名字
	 */
	private String name;

	/**
	 * 反馈人QQ
	 */
	private String qq;

	/**
	 * 反馈人电话
	 */
	private String phone;

	/**
	 * 反馈人邮箱
	 */
	private String email;

	/**
	 * 处理状态 0为未处理 1为处理
	 * 
	 */
	private Integer state;

	/**
	 * 反馈内容
	 * 
	 */
	private String feedContent;

	
	
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getFeedContent() {
		return feedContent;
	}

	public void setFeedContent(String feedContent) {
		this.feedContent = feedContent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public String getExts() {
		return exts;
	}

	public void setExts(String exts) {
		this.exts = exts;
	}

}
