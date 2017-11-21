package com.ada.approve.dao;


import java.util.List;

import  com.ada.approve.entity.FlowRecord;
import  com.quhaodian.data.core.CriteriaDao;
import com.quhaodian.data.core.Pagination;
import  com.quhaodian.data.core.Updater;

public interface FlowRecordDao extends CriteriaDao<FlowRecord, Long>{
	Pagination getPage(int pageNo, int pageSize);

	FlowRecord findById(Long id);

	FlowRecord save(FlowRecord bean);

	FlowRecord updateByUpdater(Updater<FlowRecord> updater);

	FlowRecord deleteById(Long id);

	List<FlowRecord> findByFlow(Long id);
}