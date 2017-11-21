package com.ada.approve.dao;


import  com.quhaodian.data.core.CriteriaDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import  com.ada.approve.entity.FlowDefinitionItem;

public interface FlowDefinitionItemDao extends CriteriaDao<FlowDefinitionItem,Long>{
	Pagination getPage(int pageNo, int pageSize);

	FlowDefinitionItem findById(Long id);


	FlowDefinitionItem findByDefintion(Long flow,Integer hierarchy);

	FlowDefinitionItem save(FlowDefinitionItem bean);

	FlowDefinitionItem updateByUpdater(Updater<FlowDefinitionItem> updater);

	FlowDefinitionItem deleteById(Long id);
}