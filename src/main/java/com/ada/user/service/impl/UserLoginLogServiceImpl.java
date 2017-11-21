package com.ada.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quhaodian.data.core.Finder;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;
import com.ada.user.dao.UserLoginLogDao;
import com.ada.user.entity.UserLoginLog;
import com.ada.user.service.UserLoginLogService;

import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;
@Service
@Transactional
public class UserLoginLogServiceImpl implements UserLoginLogService {
	
	
    
    
	@Transactional(readOnly = true)
	public UserLoginLog findById(Long id) {
		UserLoginLog entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public UserLoginLog save(UserLoginLog bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public UserLoginLog update(UserLoginLog bean) {
		Updater<UserLoginLog> updater = new Updater<UserLoginLog>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public UserLoginLog deleteById(Long id) {
		UserLoginLog bean = dao.findById(id);
		dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public UserLoginLog[] deleteByIds(Long[] ids) {
		UserLoginLog[] beans = new UserLoginLog[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private UserLoginLogDao dao;

	@Autowired
	public void setDao(UserLoginLogDao dao) {
		this.dao = dao;
	}
	
	
	@Transactional(readOnly = true)
	public Page<UserLoginLog> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	@Transactional(readOnly = true)
	public long count(Filter... filters){
	     
	     return dao.count(filters);
	     
	}

	@Transactional(readOnly = true)
	public List<UserLoginLog> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
	
		     return dao.findList(first,count,filters,orders);
	
	}
}