package com.ada.site.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.quhaodian.data.entity.AbstractEntity;
import com.quhaodian.data.entity.UUIDEntity;

/**
 * 
 * 通知模板
 * 
 * @author ada
 *
 */
@Entity
@Table(name = "site_template_push")
public class TemplatePush extends UUIDEntity {

	/**
	 * 模板名称
	 * 
	 */
	private String name;

	/**
	 * 通知显示的标题
	 */
	private String title;

	/**
	 * 模板备注
	 */
	private String note;

	/**
	 * 模板描述
	 */
	private String demo;

	/**
	 * 模板类型 1为系统模板 0为第三方定义模板
	 */
	private Integer catalog;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getDemo() {
		return demo;
	}

	public void setDemo(String demo) {
		this.demo = demo;
	}

	public Integer getCatalog() {
		return catalog;
	}

	public void setCatalog(Integer catalog) {
		this.catalog = catalog;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
