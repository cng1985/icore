package com.ada.article.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ada.data.entity.CatalogEntity;

/**
 * 敏感词分类
 * 
 * @author 年高
 *
 */

@Entity
@Table(name = "article_sensitive_category")
public class SensitiveCategory extends CatalogEntity {

	/**
	 * 父分类
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	private SensitiveCategory parent;

	/**
	 * 该分类下有多少敏感词
	 */
	@OneToMany(fetch = FetchType.LAZY,mappedBy="category")
	private List<SensitiveWord> words;

	@Override
	public Integer getParentId() {
		if (parent != null) {
			return parent.getId();
		} else {
			return null;

		}

	}

	public SensitiveCategory getParent() {
		return parent;
	}

	public void setParent(SensitiveCategory parent) {
		this.parent = parent;
	}

	public List<SensitiveWord> getWords() {
		return words;
	}

	public void setWords(List<SensitiveWord> words) {
		this.words = words;
	}

}
