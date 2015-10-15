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
@Table(name = "user_friend")
public class UserFriend implements Serializable{
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="userid")
	private UserInfo user;


	@ManyToOne
	@JoinColumn(name="friendid")
	private UserInfo friend;


	/**
	 * 1是申请  2是同意
	 */
	private Integer state;
	
	
	private Date addDate;
	
	private Date lastDate;

	
	/**
	 * 备注
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


	public Integer getState() {
		return state;
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

	public void setState(Integer state) {
		this.state = state;
	}


	public Date getLastDate() {
		return lastDate;
	}


	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}


	public void setUser(UserInfo user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "UserFriend [id=" + id + ", user=" + user + ", friend=" + friend
				+ "]";
	}
	
	
}
