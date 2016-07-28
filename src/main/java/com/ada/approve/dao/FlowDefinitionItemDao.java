package com.ada.approve.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.approve.entity.FlowDefinitionItem;

public interface FlowDefinitionItemDao extends CriteriaDao<FlowDefinitionItem,Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public FlowDefinitionItem findById(Long id);

	public FlowDefinitionItem save(FlowDefinitionItem bean);

	public FlowDefinitionItem updateByUpdater(Updater<FlowDefinitionItem> updater);

	public FlowDefinitionItem deleteById(Long id);
}