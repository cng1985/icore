package com.ada.admin.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ada.article.entity.ArticleCatalog;
import com.ada.data.entity.CatalogEntity;

@Entity
@Table(name = "menu")
public class Menu extends CatalogEntity {

	@JoinColumn(name = "pid")
	@ManyToOne
	private ArticleCatalog parent;

	public ArticleCatalog getParent() {
		return parent;
	}

	public void setParent(ArticleCatalog parent) {
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
