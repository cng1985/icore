package com.ada.album.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ada.user.entity.UserInfo;


@Entity
@Table(name = "album_feed")
public class PhotoFeed implements Serializable{

	@ManyToOne()
	private UserInfo user;
	
	
	@ManyToMany
	@JoinTable(name="album_photo_feeds")
	private Set<Photo> photos=new HashSet<Photo>();
	
	private Date addDate;

	private Date lastDate;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String url;
	
	private String name;

	public Date getAddDate() {
		return addDate;
	}

	public Long getId() {
		return id;
	}


	public Date getLastDate() {
		return lastDate;
	}

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Photo [id=" + id + "]";
	}

	public Set<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(Set<Photo> photos) {
		this.photos = photos;
	}
	
}
