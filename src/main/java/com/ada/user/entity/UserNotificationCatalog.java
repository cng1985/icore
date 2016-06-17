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

	/**
	 * 这个分类通知图标
	 */
	private String icon;

	public UserNotificationCatalog getParent() {
		return parent;
	}

	public void setParent(UserNotificationCatalog parent) {
		this.parent = parent;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
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
