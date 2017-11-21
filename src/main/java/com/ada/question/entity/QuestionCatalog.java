package com.ada.question.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.quhaodian.data.entity.CatalogEntity;

@Entity
@Table(name = "question_catalog")
public class QuestionCatalog extends CatalogEntity {

	@OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
	private List<QuestionCatalog> childrens;

	private String icon;

	
	@JoinColumn(name = "pid")
	@ManyToOne(fetch = FetchType.LAZY)
	private QuestionCatalog parent;
	/**
	 * 数量
	 */
	private Long nums;
	
	public Long getNums() {
		return nums;
	}

	public void setNums(Long nums) {
		this.nums = nums;
	}

	private String path;
	public List<QuestionCatalog> getChildrens() {
		return childrens;
	}

	public String getIcon() {
		return icon;
	}

	public QuestionCatalog getParent() {
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

	public void setChildrens(List<QuestionCatalog> childrens) {
		this.childrens = childrens;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public void setParent(QuestionCatalog parent) {
		this.parent = parent;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	

}
