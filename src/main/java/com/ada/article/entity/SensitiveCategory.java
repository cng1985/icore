package com.ada.article.entity;

import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.ada.data.entity.CatalogEntity;

/**
 * 敏感词分类
 * 
 * @author 年高
 *
 */
public class SensitiveCategory extends CatalogEntity {

	/**
	 * 父分类
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	private SensitiveCategory parent;

	/**
	 * 该分类下有多少敏感词
	 */
	@OneToMany(fetch = FetchType.LAZY)
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
