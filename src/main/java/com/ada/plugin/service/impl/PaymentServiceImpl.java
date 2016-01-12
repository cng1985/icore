package com.ada.plugin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.ada.plugin.dao.PaymentDao;
import com.ada.plugin.entity.Payment;
import com.ada.plugin.service.PaymentService;
import com.ada.plugin.page.PaymentPage;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
	

	@Transactional(readOnly = true)
	public Payment findById(Long id) {
		Payment entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public Payment save(Payment bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public Payment update(Payment bean) {
		Updater<Payment> updater = new Updater<Payment>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public Payment deleteById(Long id) {
		Payment bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public Payment[] deleteByIds(Long[] ids) {
		Payment[] beans = new Payment[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private PaymentDao dao;

	@Autowired
	public void setDao(PaymentDao dao) {
		this.dao = dao;
	}
	
	@Transactional(readOnly = true)
	public PaymentPage getPage(int pageNo, int pageSize) {
	    PaymentPage result = null;
		Finder finder=Finder.create();
		finder.append("from Payment f ");
		finder.append(" order by f.id desc  ");
		Pagination<Payment> page = dao.find(finder,pageNo, pageSize);
		result = new PaymentPage(page);
		return result;
	}
	
	
	@Transactional(readOnly = true)
	public Page<Payment> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	@Transactional(readOnly = true)
	public long count(Filter... filters){
	     
	     return dao.count(filters);
	     
	}

	@Transactional(readOnly = true)
	public List<Payment> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
	
		     return dao.findList(first,count,filters,orders);
	
	}

	
	@Transactional(readOnly = true)
	@Override
	public Payment findBySn(String sn) {
		String jpql = "select payment from Payment payment where lower(payment.sn) = lower(:sn)";
		Finder finder=Finder.create();
		finder.append(jpql);
		finder.setParam("sn", sn);
		Payment result=	dao.findOne(finder);
		
		return result;
	}
}