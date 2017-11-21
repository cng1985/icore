package com.ada.question.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.quhaodian.data.entity.AbstractEntity;
import com.ada.user.entity.UserInfo;



@Entity
@Table(name = "question_favorite")
public class QuestionFavorite extends AbstractEntity {


	
	/**
	 * 用户
	 */
	@JoinColumn(name = "userid")
	@ManyToOne()
	private UserInfo user;
	
	@JoinColumn
	@ManyToOne()
	private Question question;
	
	



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



	
}
