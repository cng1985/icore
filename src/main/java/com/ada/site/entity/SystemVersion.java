package com.ada.site.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.ada.data.entity.AbstractEntity;

/**
 * Entity - 配置版本管理
 * 
 */
@Entity
@Table(name = "config_version")
public class SystemVersion extends AbstractEntity {

	/**
	 * 最高版本数据
	 */
	private Long versionnum;

	/**
	 * 版本数据
	 */
	private String sequence;
	
	/**
	 * 步长 默认为1
	 */
	private Integer step;

	
	
	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public Integer getStep() {
		return step;
	}

	public void setStep(Integer step) {
		this.step = step;
	}

	public Long getVersionnum() {
		return versionnum;
	}

	public void setVersionnum(Long versionnum) {
		this.versionnum = versionnum;
	}


}
