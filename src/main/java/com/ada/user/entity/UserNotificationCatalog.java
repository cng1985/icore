package com.ada.user.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ada.data.entity.CatalogEntity;

@Entity
@Table(name = "user_notification_catalog")
public class UserNotificationCatalog extends CatalogEntity {

	/**
	 * 父分类id
	 */
	@ManyToOne
	@JoinColumn(name = "pid")
	private UserNotificationCatalog parent;

	public UserNotificationCatalog getParent() {
		return parent;
	}

	public void setParent(UserNotificationCatalog parent) {
		this.parent = parent;
	}

	@Override
	public Integer getParentId() {
		if (parent != null) {
			return parent.getId();
		} else {
			return null;
		}
	}

}
