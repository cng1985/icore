package com.ada.user.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.quhaodian.data.entity.AbstractEntity;



@Entity
@Table(name = "user_message")
public class UserMessage extends AbstractEntity {

	
	/**
	 * 对应的主题
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	private UserMessageSubject subject;

	/**
	 * 发消息的用户
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	private UserInfo user;

	/**
	 * 消息
	 */
	private String message;

	/**
	 * 0为正常<br/>
	 * 1为删除
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	
	

}
