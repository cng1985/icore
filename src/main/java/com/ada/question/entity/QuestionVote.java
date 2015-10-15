package com.ada.question.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ada.user.entity.UserInfo;

@Entity
@Table(name = "question_vote")
public class QuestionVote {

	@Id
	@GeneratedValue
	private Long id;

	/**
	 * 用户
	 */
	@JoinColumn(name = "userid")
	@ManyToOne()
	private UserInfo user;

	/**
	 * 问题的回答
	 */
	@JoinColumn
	@ManyToOne()
	private QuestionAnswer answer;
	
	/**
	 * 投票数量
	 */
	private Integer vote;
	
	/**
	 * 投票类型
	 */
	private Integer flag;

	public QuestionAnswer getAnswer() {
		return answer;
	}

	public Integer getFlag() {
		return flag;
	}

	public Long getId() {
		return id;
	}

	public UserInfo getUser() {
		return user;
	}


	public Integer getVote() {
		return vote;
	}

	public void setAnswer(QuestionAnswer answer) {
		this.answer = answer;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public void setVote(Integer vote) {
		this.vote = vote;
	}
	
	
}
