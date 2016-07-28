package com.ada.approve.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.approve.entity.FlowDefinition;

public interface FlowDefinitionDao extends CriteriaDao<FlowDefinition,Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public FlowDefinition findById(Long id);

	public FlowDefinition save(FlowDefinition bean);

	public FlowDefinition updateByUpdater(Updater<FlowDefinition> updater);

	public FlowDefinition deleteById(Long id);
}