package com.ada.approve.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ada.data.entity.AbstractEntity;

/**
 * 流程定义
 * 
 * @author ada
 *
 */
@Entity
@Table(name = "approve_flow_definition")
public class FlowDefinition extends AbstractEntity {

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "flow")
	private List<FlowDefinitionItem> items;

	private String name;

	/**
	 * 内容查看url
	 */
	private String viewurl;

	public List<FlowDefinitionItem> getItems() {
		return items;
	}

	public String getName() {
		return name;
	}

	public String getViewurl() {
		return viewurl;
	}

	public void setItems(List<FlowDefinitionItem> items) {
		this.items = items;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setViewurl(String viewurl) {
		this.viewurl = viewurl;
	}

}
