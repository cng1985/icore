package com.ada.data.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class SortEntity extends AbstractEntity {

	private Integer sortnum;

	public Integer getSortnum() {
		return sortnum;
	}

	public void setSortnum(Integer sortnum) {
		this.sortnum = sortnum;
	}

}