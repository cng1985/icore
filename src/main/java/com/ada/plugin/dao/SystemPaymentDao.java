package com.ada.plugin.dao;


import  com.quhaodian.data.core.CriteriaDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import  com.ada.plugin.entity.SystemPayment;

public interface SystemPaymentDao extends CriteriaDao<SystemPayment, Long>{
	Pagination getPage(int pageNo, int pageSize);

	SystemPayment findById(Long id);

	SystemPayment save(SystemPayment bean);

	SystemPayment updateByUpdater(Updater<SystemPayment> updater);

	SystemPayment deleteById(Long id);
}