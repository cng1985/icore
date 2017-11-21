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

import com.quhaodian.data.entity.AbstractEntity;
import com.ada.user.entity.UserInfo;


@Entity
@Table(name = "album_feed")
public class PhotoFeed extends AbstractEntity{

	@ManyToOne()
	private UserInfo user;
	
	
	@ManyToMany
	@JoinTable(name="album_photo_feeds")
	private Set<Photo> photos=new HashSet<Photo>();
	
	
	private String url;
	
	private String name;


	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}

	public UserInfo getUser() {
		return user;
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


	public Set<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(Set<Photo> photos) {
		this.photos = photos;
	}
	
}
