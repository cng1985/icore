package com.ada.feed.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ada.article.entity.Article;
import com.ada.user.entity.UserInfo;

/**
 * 动态评论
 * 
 * @author 年高
 *
 */
@Entity
@Table(name = "feed_comment")
public class FeedComment implements Serializable {

	private Date addDate;


	private String contents;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Date lastDate;
	private String title;
	
	@ManyToOne()
	private Feed feed;
	
	@ManyToOne()
	private UserInfo user;
	
	
	
	

	public Date getAddDate() {
		return addDate;
	}



	public String getContents() {
		return contents;
	}

	public Long getId() {
		return id;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public String getTitle() {
		return title;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}



	public void setContents(String contents) {
		this.contents = contents;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}



	public Feed getFeed() {
		return feed;
	}



	public void setFeed(Feed feed) {
		this.feed = feed;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FeedComment other = (FeedComment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
