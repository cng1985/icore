package com.ada.user.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ada.data.entity.AbstractEntity;


@Entity
@Table(name = "user_message_subject")
public class UserMessageSubject extends AbstractEntity {

	/**
	 * 用户
	 */
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="uid")
	private UserInfo user;

	/**
	 * 主题
	 */
	private String subject;

	/**
	 * 消息类型 1为私信 2为群聊
	 */
	private Integer catalog;

	/**
	 * 参与人数
	 */
	private Integer members;

	/**
	 * 最后消息
	 */
	private String lastMessage;

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Integer getCatalog() {
		return catalog;
	}

	public void setCatalog(Integer catalog) {
		this.catalog = catalog;
	}

	public Integer getMembers() {
		return members;
	}

	public void setMembers(Integer members) {
		this.members = members;
	}

	public String getLastMessage() {
		return lastMessage;
	}

	public void setLastMessage(String lastMessage) {
		this.lastMessage = lastMessage;
	}
}
