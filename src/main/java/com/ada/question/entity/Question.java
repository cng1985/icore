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

/**
 * 提问
 * 
 * @author ada
 *
 */
@Entity
@Table(name = "question")
public class Question implements Serializable {

	/**
	 * 添加时间
	 */
	private Date addDate;

	/**
	 * 该问题有多少个回答
	 */
	private Integer answers;
	
	/**
	 * 该问题有多少个查看
	 */
	private Integer views;
	
	

	/**
	 * 该问题有多少个投票
	 */
	private Integer votes;

	/**
	 * 问题分类
	 */
	@JoinColumn
	@ManyToOne()
	private QuestionCatalog catalog;

	/**
	 * 标题
	 */
	private String contents;

	/**
	 * 该问题有多少个人收藏
	 */
	private Integer favorites;

	@Id
	@GeneratedValue
	private Long id;

	/**
	 * 图片集合
	 */
	private String images;

	/**
	 * 更新时间
	 */
	private Date lastDate;

	/**
	 * 是否解决
	 */
	private Integer state;

	/**
	 * 标题
	 */
	private String title;

	/**
	 * 用户
	 */
	@JoinColumn(name = "userid")
	@ManyToOne()
	private UserInfo user;

	public Integer getVotes() {
		return votes;
	}

	public void setVotes(Integer votes) {
		this.votes = votes;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Date getAddDate() {
		return addDate;
	}

	public Integer getAnswers() {
		return answers;
	}

	public QuestionCatalog getCatalog() {
		return catalog;
	}

	public String getContents() {
		return contents;
	}

	public Integer getFavorites() {
		return favorites;
	}

	public Long getId() {
		return id;
	}

	public String getImages() {
		return images;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public Integer getState() {
		return state;
	}

	public String getTitle() {
		return title;
	}

	public UserInfo getUser() {
		return user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public void setAnswers(Integer answers) {
		this.answers = answers;
	}

	public void setCatalog(QuestionCatalog catalog) {
		this.catalog = catalog;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public void setFavorites(Integer favorites) {
		this.favorites = favorites;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", title=" + title + "]";
	}

}
