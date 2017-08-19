package com.ada.approve.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.approve.entity.FlowDefinition;

public interface FlowDefinitionDao extends CriteriaDao<FlowDefinition,Long>{
	Pagination getPage(int pageNo, int pageSize);

	FlowDefinition findById(Long id);

	FlowDefinition save(FlowDefinition bean);

	FlowDefinition updateByUpdater(Updater<FlowDefinition> updater);

	FlowDefinition deleteById(Long id);
}