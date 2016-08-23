package com.ada.user.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ada.data.entity.AbstractEntity;

@Entity
@Table(name = "user_message_member")
public class UserMessageMember extends AbstractEntity {

	/**
	 * 消息主题
	 */
	@JoinColumn(name = "subjectid")
	@ManyToOne(fetch = FetchType.LAZY)
	private UserMessageSubject subject;

	/**
	 * 用户
	 */
	@JoinColumn(name = "uid")
	@ManyToOne(fetch = FetchType.LAZY)
	private UserInfo user;

	/**
	 * 消息数量
	 */
	private Integer nums;

	/**
	 * 0 为没有最新消息<br/>
	 * 1为有最新消息
	 */
	private Integer state;

	public UserMessageSubject getSubject() {
		return subject;
	}

	public void setSubject(UserMessageSubject subject) {
		this.subject = subject;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public Integer getNums() {
		return nums;
	}

	public void setNums(Integer nums) {
		this.nums = nums;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}
