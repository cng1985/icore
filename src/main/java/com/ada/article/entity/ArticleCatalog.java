package com.ada.article.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ada.data.entity.CatalogEntity;

/**
 * 文章分类
 * 
 * @author 年高
 *
 */
@Entity
@Table(name = "article_catalog")
public class ArticleCatalog extends CatalogEntity {

	@JoinColumn(name = "pid")
	@ManyToOne
	private ArticleCatalog parent;
	
	
	@OneToMany(mappedBy = "parent", fetch = FetchType.EAGER)
	private List<ArticleCatalog> childrens;

	@Override
	public Integer getParentId() {
		if (parent != null) {
			return parent.getId();
		}
		return null;
	}

	public ArticleCatalog getParent() {
		return parent;
	}

	public void setParent(ArticleCatalog parent) {
		this.parent = parent;
	}

	public List<ArticleCatalog> getChildrens() {
		return childrens;
	}

	public void setChildrens(List<ArticleCatalog> childrens) {
		this.childrens = childrens;
	}
	
	

}
