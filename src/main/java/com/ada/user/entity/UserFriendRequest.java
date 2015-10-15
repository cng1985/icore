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
@Table(name = "user_friend_request")
public class UserFriendRequest implements Serializable {

	public UserFriendRequest(){
		addDate=new Date();
		lastDate=new Date();
	}
	@Id
	@GeneratedValue
	private Long id;
	
	/**
	 *   用户
	 */
	@ManyToOne
	@JoinColumn(name="userid")
	private UserInfo user;
	
	/**
	 *  被请求用户
	 */
	@ManyToOne
	@JoinColumn(name="friendid")
	private UserInfo friend;
	
	/**
	 *  请求好友时间戳
	 */
	private Date addDate;
	
	/**
	 *  请求好友修改时间戳
	 */
	private Date lastDate;

	/**
	 * 申请附言
	 */
	private String note;

	public Date getAddDate() {
		return addDate;
	}

	public UserInfo getFriend() {
		return friend;
	}

	public Long getId() {
		return id;
	}

	public String getNote() {
		return note;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public void setFriend(UserInfo friend) {
		this.friend = friend;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}
	
	
	
}
