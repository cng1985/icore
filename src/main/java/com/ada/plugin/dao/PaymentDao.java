package com.ada.plugin.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.plugin.entity.Payment;

public interface PaymentDao extends CriteriaDao<Payment, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public Payment findById(Long id);

	public Payment save(Payment bean);

	public Payment updateByUpdater(Updater<Payment> updater);

	public Payment deleteById(Long id);
}