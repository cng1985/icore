package com.ada.question.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ada.user.entity.UserInfo;



@Entity
@Table(name = "question_favorite")
public class QuestionFavorite implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	
	
	/**
	 * 用户
	 */
	@JoinColumn(name = "userid")
	@ManyToOne()
	private UserInfo user;
	
	@JoinColumn
	@ManyToOne()
	private Question question;
	
	
	/**
	 * 添加时间
	 */
	private Date addDate;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public UserInfo getUser() {
		return user;
	}


	public void setUser(UserInfo user) {
		this.user = user;
	}


	public Question getQuestion() {
		return question;
	}


	public void setQuestion(Question question) {
		this.question = question;
	}


	public Date getAddDate() {
		return addDate;
	}


	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	
	
}
