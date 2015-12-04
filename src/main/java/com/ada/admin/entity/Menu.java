package com.ada.admin.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ada.data.entity.CatalogEntity;

@Entity
@Table(name = "menu")
public class Menu extends CatalogEntity {

	@JoinColumn(name = "pid")
	@ManyToOne
	private Menu parent;

	/**
	 * 图标
	 */
	private String icon;

	/**
	 * url地址
	 */
	private String path;

	@OneToMany(mappedBy = "parent", fetch = FetchType.EAGER)
	private List<Menu> childrens;

	public List<Menu> getChildrens() {
		if (childrens != null && childrens.size() > 0) {
			return childrens;

		} else {
			return null;

		}
	}

	public String getIcon() {
		return icon;
	}

	public Menu getParent() {
		return parent;
	}

	@Override
	public Integer getParentId() {
		if (parent != null) {
			return parent.getId();
		} else {
			return null;
		}
	}

	public String getPath() {
		return path;
	}

	public void setChildrens(List<Menu> childrens) {
		this.childrens = childrens;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public void setParent(Menu parent) {
		this.parent = parent;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
