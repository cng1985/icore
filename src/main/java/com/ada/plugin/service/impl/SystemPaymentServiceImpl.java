package com.ada.plugin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quhaodian.data.core.Finder;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;
import com.ada.plugin.dao.SystemPaymentDao;
import com.ada.plugin.entity.SystemPayment;
import com.ada.plugin.service.SystemPaymentService;
import com.ada.plugin.page.SystemPaymentPage;

import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;


@Service
@Transactional
public class SystemPaymentServiceImpl implements SystemPaymentService {
	

	@Transactional(readOnly = true)
	public SystemPayment findById(Long id) {
		SystemPayment entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public SystemPayment save(SystemPayment bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public SystemPayment update(SystemPayment bean) {
		Updater<SystemPayment> updater = new Updater<SystemPayment>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public SystemPayment deleteById(Long id) {
		SystemPayment bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public SystemPayment[] deleteByIds(Long[] ids) {
		SystemPayment[] beans = new SystemPayment[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private SystemPaymentDao dao;

	@Autowired
	public void setDao(SystemPaymentDao dao) {
		this.dao = dao;
	}
	
	@Transactional(readOnly = true)
	public SystemPaymentPage getPage(int pageNo, int pageSize) {
	    SystemPaymentPage result = null;
		Finder finder=Finder.create();
		finder.append("from SystemPayment f ");
		finder.append(" order by f.id desc  ");
		Pagination<SystemPayment> page = dao.find(finder,pageNo, pageSize);
		result = new SystemPaymentPage(page);
		return result;
	}
	
	
	@Transactional(readOnly = true)
	public Page<SystemPayment> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	@Transactional(readOnly = true)
	public long count(Filter... filters){
	     
	     return dao.count(filters);
	     
	}

	@Transactional(readOnly = true)
	public List<SystemPayment> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
	
		     return dao.findList(first,count,filters,orders);
	
	}

	@Transactional(readOnly = true)
	@Override
	public SystemPayment findBySn(String sn) {
		String jpql = "select payment from Payment payment where lower(payment.sn) = lower(:sn)";
		Finder finder=Finder.create();
		finder.append(jpql);
		finder.setParam("sn", sn);
		SystemPayment result=	dao.findOne(finder);
		
		return result;
	}
}