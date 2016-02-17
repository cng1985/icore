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
	 * 流程分类
	 */
	private Integer catalog;

	/**
	 * 当前审批层级
	 */
	private Integer hierarchy;

	/**
	 * 审核状态 0为未审核1为审核中2审核完成
	 */
	private Integer state;

	/**
	 * 流程描述
	 */
	private String note;

	/**
	 * 数据id
	 */
	private Long oid;

	/**
	 * 流程名称
	 */
	private String title;

	/**
	 * 用户
	 */
	@ManyToOne
	private UserInfo user;

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getCatalog() {
		return catalog;
	}

	public Integer getHierarchy() {
		return hierarchy;
	}

	public String getNote() {
		return note;
	}

	public Long getOid() {
		return oid;
	}

	public String getTitle() {
		return title;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setCatalog(Integer catalog) {
		this.catalog = catalog;
	}

	public void setHierarchy(Integer hierarchy) {
		this.hierarchy = hierarchy;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

}
