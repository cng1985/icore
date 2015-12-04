package com.ada.data.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import com.ada.common.hibernate.HibernateTree;

/**
 * 分类基础类
 * 
 * @author 年高
 *
 */
@MappedSuperclass
public class CatalogEntity implements HibernateTree<Integer>, Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private java.lang.String name;

	private Integer sortnum;

	private java.lang.String path;

	private java.lang.String icon;

	private java.lang.String ids;

	private java.lang.Integer lft;

	private java.lang.Integer rgt;

	private Integer levelinfo;
	@JoinColumn(name = "pid")
	@ManyToOne
	private CatalogEntity parent;
	@OneToMany(mappedBy = "parent", fetch = FetchType.EAGER)
	private List<CatalogEntity> childrens;

	public List<CatalogEntity> getChildrens() {
		if (childrens != null && childrens.size() > 0) {
			return childrens;

		} else {
			return null;

		}
	}

	public java.lang.String getIcon() {
		return icon;
	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public java.lang.String getIds() {
		return ids;
	}

	public Integer getLevelinfo() {
		return levelinfo;
	}

	public java.lang.Integer getLft() {
		return lft;
	}

	/**
	 * @see HibernateTree#getLftName()
	 */
	public String getLftName() {
		return DEF_LEFT_NAME;
	}

	public java.lang.String getName() {
		return name;
	}

	public CatalogEntity getParent() {
		return parent;
	}

	public Integer getParentId() {
		CatalogEntity parent = getParent();
		if (parent != null) {
			return parent.getId();
		} else {
			return null;
		}
	}

	/**
	 * @see HibernateTree#getParentName()
	 */
	public String getParentName() {
		return DEF_PARENT_NAME;
	}

	public java.lang.String getPath() {
		return path;
	}

	public java.lang.Integer getRgt() {
		return rgt;
	}

	/**
	 * @see HibernateTree#getRgtName()
	 */
	public String getRgtName() {
		return DEF_RIGHT_NAME;
	}

	public Integer getSortnum() {
		return sortnum;
	}

	@Override
	public String getTreeCondition() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setChildrens(List<CatalogEntity> childrens) {
		this.childrens = childrens;
	}

	public void setIcon(java.lang.String icon) {
		this.icon = icon;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setIds(java.lang.String ids) {
		this.ids = ids;
	}

	public void setLevelinfo(Integer levelinfo) {
		this.levelinfo = levelinfo;
	}

	public void setLft(java.lang.Integer lft) {
		this.lft = lft;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public void setParent(CatalogEntity parent) {
		this.parent = parent;
	}

	public void setPath(java.lang.String path) {
		this.path = path;
	}

	public void setRgt(java.lang.Integer rgt) {
		this.rgt = rgt;
	}

	public void setSortnum(Integer sortnum) {
		this.sortnum = sortnum;
	}
}
