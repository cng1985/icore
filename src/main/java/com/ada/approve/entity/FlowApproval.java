package com.ada.approve.entity;

import com.quhaodian.data.entity.AbstractEntity;
import com.ada.user.entity.UserInfo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 流程审批节点
 * 
 * @author ada
 *
 */
@Entity
@Table(name = "approve_flow_approval")
public class FlowApproval extends AbstractEntity {

	/**
	 * 审批人
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	private UserInfo user;

	/**
	 * 流程
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	private Flow flow;

	/**
	 * 层级
	 */
	private Integer hierarchy;

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public Flow getFlow() {
		return flow;
	}

	public void setFlow(Flow flow) {
		this.flow = flow;
	}

	public Integer getHierarchy() {
		return hierarchy;
	}

	public void setHierarchy(Integer hierarchy) {
		this.hierarchy = hierarchy;
	}
	
	

}
