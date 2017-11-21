package com.ada.approve.dao;


import  com.quhaodian.data.core.CriteriaDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import  com.ada.approve.entity.FlowDefinition;

public interface FlowDefinitionDao extends CriteriaDao<FlowDefinition,Long>{
	Pagination getPage(int pageNo, int pageSize);

	FlowDefinition findById(Long id);

	FlowDefinition save(FlowDefinition bean);

	FlowDefinition updateByUpdater(Updater<FlowDefinition> updater);

	FlowDefinition deleteById(Long id);
}