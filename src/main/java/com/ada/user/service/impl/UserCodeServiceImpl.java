package com.ada.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.ada.user.dao.UserCodeDao;
import com.ada.user.entity.UserCode;
import com.ada.user.service.UserCodeService;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


@Service
@Transactional
public class UserCodeServiceImpl implements UserCodeService {
	

	@Transactional(readOnly = true)
	public UserCode findById(Long id) {
		UserCode entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public UserCode save(UserCode bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public UserCode update(UserCode bean) {
		Updater<UserCode> updater = new Updater<UserCode>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public UserCode deleteById(Long id) {
		UserCode bean = dao.deleteById(id);
		dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public UserCode[] deleteByIds(Long[] ids) {
		UserCode[] beans = new UserCode[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private UserCodeDao dao;

	@Autowired
	public void setDao(UserCodeDao dao) {
		this.dao = dao;
	}
	
	
	@Transactional(readOnly = true)
	public Page<UserCode> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	@Transactional(readOnly = true)
	public long count(Filter... filters){
	     
	     return dao.count(filters);
	     
	}

	@Transactional(readOnly = true)
	public List<UserCode> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
	
		     return dao.findList(first,count,filters,orders);
	
	}
}