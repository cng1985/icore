package com.ada.approve.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ada.data.entity.AbstractEntity;
import com.ada.user.entity.UserInfo;

/**
 * 审批流程
 * 
 * @author ada
 *
 */
@Entity
@Table(name = "approve_flow")
public class Flow extends AbstractEntity {

	/**
	 * 流程名称
	 */
	private String title;

	/**
	 * 流程描述
	 */
	private String note;
	
	
	/**
	 * 流程分类
	 */
	private Integer catalog;
	
	
	/**
	 * 用户
	 */
	@ManyToOne
	private UserInfo user;
	
	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	/**
	 * 数据id
	 */
	private Long oid;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getCatalog() {
		return catalog;
	}

	public void setCatalog(Integer catalog) {
		this.catalog = catalog;
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

}
