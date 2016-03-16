package com.ada.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ada.data.entity.AbstractEntity;

/**
 * 用户使用过的设备
 */
@Entity
@Table(name = "user_device")
public class UserDevice extends AbstractEntity {

	/**
	 * 设备名称
	 */
	private String name;

	/**
	 * 设备代码
	 */
	private String code;

	/**
	 * 使用次数
	 */
	private Integer times;

	/**
	 * 设备类型 手机、平板
	 */
	private String catalog;

	/**
	 * 0 为正常 1为禁用该设备
	 */
	private Integer state;

	/**
	 * 设备类型 mac、手机串码
	 */
	private String source;

	/**
	 * 用户
	 */
	@ManyToOne
	@JoinColumn(name = "userid")
	private UserInfo user;

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getTimes() {
		return times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}

	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

}
