package com.ada.album.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ada.user.entity.UserInfo;

@Entity
@Table(name = "album_album")
public class Album implements Serializable {

	private Date addDate;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Date lastDate;

	private String name;

	@ManyToOne()
	private UserInfo user;

	public Album() {
		addDate = new Date();
		lastDate = new Date();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Album other = (Album) obj;
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

	public Long getId() {
		return id;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public String getName() {
		return name;
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

	public void setId(Long id) {
		this.id = id;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

}
