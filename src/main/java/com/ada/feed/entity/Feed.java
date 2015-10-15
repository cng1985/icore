package com.ada.feed.entity;

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
 * 动态
 * @author 年高
 *
 */

@Entity
@Table(name = "feed")
public class Feed implements Serializable{
	
	
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
	 * 添加时间
	 */
	private Date addDate;

	/**
	 * 更新时间
	 */
	private Date lastDate;
	
	/**
	 * 动态内容
	 */
	private String note;
	/**
	 * 动态分类
	 */
	private Integer catalog;
	
	/**
	 * 动态评论数量
	 */
	private Integer comments;
	
	/**
	 * 发布时候的图片集合
	 */
	private String images;
	
	public String getImages() {
		return images;
	}


	public void setImages(String images) {
		this.images = images;
	}


	/**
	 * 动态扩展信息 最好用json
	 */
	private String exts;


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


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	public Integer getCatalog() {
		return catalog;
	}


	public void setCatalog(Integer catalog) {
		this.catalog = catalog;
	}


	public String getExts() {
		return exts;
	}


	public void setExts(String exts) {
		this.exts = exts;
	}


	public Integer getComments() {
		return comments;
	}


	public void setComments(Integer comments) {
		this.comments = comments;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Feed other = (Feed) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
