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
@Table(name = "question_answer")
public class QuestionAnswer implements Serializable {
	
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
	 * 标题
	 */
	private String title;

	/**
	 * 标题
	 */
	private String contents;

	/**
	 * 图片集合
	 */
	private String images;

	/**
	 * 支持人数
	 */
	private Integer ups;
	
	/**
	 * 添加时间
	 */
	private Date addDate;

	/**
	 * 更新时间
	 */
	private Date lastDate;
	
	
	/**
	 * 回答是否被采纳
	 */
	private Integer state;

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getContents() {
		return contents;
	}
	
	public Long getId() {
		return id;
	}

	public String getImages() {
		return images;
	}

	public Question getQuestion() {
		return question;
	}

	public String getTitle() {
		return title;
	}

	public Integer getUps() {
		return ups;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setUps(Integer ups) {
		this.ups = ups;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	
	
	
}
