package com.ada.approve.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ada.data.entity.AbstractEntity;
import com.ada.user.entity.UserInfo;


/**
 * 审批过程中的任务
 * @author 73552
 *
 */
@Entity
@Table(name = "approve_task")
public class Task extends AbstractEntity {

	
	/**
	 * 用户
	 */
	@ManyToOne
	private UserInfo user;
	
	/**
	 * 流程
	 */
	@ManyToOne
	private Flow flow;
	
	public Flow getFlow() {
		return flow;
	}

	public void setFlow(Flow flow) {
		this.flow = flow;
	}

	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 内容
	 */
	private String note;
	
	/**
	 * 分类
	 */
	private Integer catalog;
	
	/**
	 * 是否处理 0为未处理 1为处理过了
	 */
	private Integer state;
	
	
	/**
	 * 数据id
	 */
	private Long oid;

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

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

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	
	
}
