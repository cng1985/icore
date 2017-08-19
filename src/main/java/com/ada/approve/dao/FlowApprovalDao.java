package com.ada.approve.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;

import java.util.List;

import  com.ada.approve.entity.FlowApproval;

public interface FlowApprovalDao extends CriteriaDao<FlowApproval, Long>{
	Pagination getPage(int pageNo, int pageSize);

	FlowApproval findById(Long id);

	FlowApproval save(FlowApproval bean);

	FlowApproval updateByUpdater(Updater<FlowApproval> updater);

	FlowApproval deleteById(Long id);
	
	Integer deleteByFlow(Long id);


	FlowApproval findNext(Long id, Integer hierarchy);
	
	FlowApproval findCur(Long id, Integer hierarchy);

	FlowApproval findPre(Long id, Integer hierarchy);

	List<FlowApproval> findByFlow(Long id);
}