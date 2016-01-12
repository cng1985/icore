package com.ada.plugin.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.plugin.entity.SystemPayment;

public interface SystemPaymentDao extends CriteriaDao<SystemPayment, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public SystemPayment findById(Long id);

	public SystemPayment save(SystemPayment bean);

	public SystemPayment updateByUpdater(Updater<SystemPayment> updater);

	public SystemPayment deleteById(Long id);
}