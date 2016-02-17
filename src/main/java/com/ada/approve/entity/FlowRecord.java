package com.ada.approve.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ada.data.entity.AbstractEntity;
import com.ada.user.entity.UserInfo;

@Entity
@Table(name = "approve_flow_record")
public class FlowRecord extends AbstractEntity {

	/**
	 * 用户
	 */
	@ManyToOne
	private UserInfo user;

	/**
	 * 
	 * 审批状态 0为不同意 1为同意
	 * 
	 */
	private Integer state;
	
	/**
	 * 层级
	 */
	private Integer hierarchy;

	/**
	 * 审批意见
	 */
	private String note;
	
	
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

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getHierarchy() {
		return hierarchy;
	}

	public void setHierarchy(Integer hierarchy) {
		this.hierarchy = hierarchy;
	}
	
	
	
}
