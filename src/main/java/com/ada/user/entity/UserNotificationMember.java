package com.ada.user.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ada.data.entity.AbstractEntity;

@Entity
@Table(name = "user_notification_member")
public class UserNotificationMember extends AbstractEntity {

	@ManyToOne
	@JoinColumn(name="notificationid")
	private UserNotification notification;

	@ManyToOne
	@JoinColumn(name="uid")
	private UserInfo user;

	/**
	 * 阅读状态 1为已读0为未读
	 */
	private Integer state;

	public UserNotification getNotification() {
		return notification;
	}

	public void setNotification(UserNotification notification) {
		this.notification = notification;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	
	
}
