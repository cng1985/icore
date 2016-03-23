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
	 * 分类  1为请假	2为工作汇报	3为项目	4为邮件冻结
	 */
	private Integer catalog;
	
	/**
	 * 流程
	 */
	@ManyToOne
	private Flow flow;
	
	/**
	 * 内容
	 */
	private String note;

	/**
	 * 数据id
	 */
	private Long oid;

	/**
	 * 是否处理 0为未处理 1为处理过了
	 */
	private Integer state;
	
	/**
	 * 事务类型 	1为审批	2为事务 3查看
	 */
	private Integer style;
	
	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 用户
	 */
	@ManyToOne
	private UserInfo user;
	
	
	public Integer getCatalog() {
		return catalog;
	}
	
	
	public Flow getFlow() {
		return flow;
	}

	public String getNote() {
		return note;
	}

	public Long getOid() {
		return oid;
	}

	public Integer getState() {
		return state;
	}

	public Integer getStyle() {
		return style;
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

	public void setFlow(Flow flow) {
		this.flow = flow;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public void setStyle(Integer style) {
		this.style = style;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}
	
	
}
