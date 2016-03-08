package com.ada.approve.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;

import java.util.List;

import  com.ada.approve.entity.FlowApproval;

public interface FlowApprovalDao extends CriteriaDao<FlowApproval, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public FlowApproval findById(Long id);

	public FlowApproval save(FlowApproval bean);

	public FlowApproval updateByUpdater(Updater<FlowApproval> updater);

	public FlowApproval deleteById(Long id);
	
	public Integer deleteByFlow(Long id);


	public FlowApproval findNext(Long id, Integer hierarchy);
	
	public FlowApproval findCur(Long id, Integer hierarchy);

	public FlowApproval findPre(Long id, Integer hierarchy);

	public List<FlowApproval> findByFlow(Long id);
}