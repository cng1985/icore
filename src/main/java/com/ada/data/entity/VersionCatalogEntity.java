package com.ada.data.entity;

import javax.persistence.MappedSuperclass;

/**
 * 树形结构版本同步实体
 * 
 * @author aniaojian
 *
 */
@MappedSuperclass
public abstract class VersionCatalogEntity extends CatalogEntity {

	private Long versionnum;

	/**
	 * 状态 1 为增加 2为更新 3为删除
	 */
	private Integer state;

	public Long getVersionnum() {
		return versionnum;
	}

	public void setVersionnum(Long versionnum) {
		this.versionnum = versionnum;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}
