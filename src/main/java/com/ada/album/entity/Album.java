package com.ada.album.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.quhaodian.data.entity.AbstractEntity;
import com.ada.user.entity.UserInfo;

@Entity
@Table(name = "album_album")
public class Album extends AbstractEntity {


	private String name;

	@ManyToOne()
	private UserInfo user;



	public String getName() {
		return name;
	}

	public UserInfo getUser() {
		return user;
	}


	public void setName(String name) {
		this.name = name;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

}
