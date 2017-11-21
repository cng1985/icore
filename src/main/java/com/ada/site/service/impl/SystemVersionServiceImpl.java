package com.ada.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quhaodian.data.core.Finder;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;
import com.ada.site.dao.SystemVersionDao;
import com.ada.site.entity.SystemVersion;
import com.ada.site.service.SystemVersionService;

import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;


@Service
@Transactional
public class SystemVersionServiceImpl implements SystemVersionService {
	

	@Transactional(readOnly = true)
	public SystemVersion findById(Long id) {
		SystemVersion entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public SystemVersion save(SystemVersion bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public SystemVersion update(SystemVersion bean) {
		Updater<SystemVersion> updater = new Updater<SystemVersion>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public SystemVersion deleteById(Long id) {
		SystemVersion bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public SystemVersion[] deleteByIds(Long[] ids) {
		SystemVersion[] beans = new SystemVersion[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private SystemVersionDao dao;

	@Autowired
	public void setDao(SystemVersionDao dao) {
		this.dao = dao;
	}
	
	
	@Transactional(readOnly = true)
	public Page<SystemVersion> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	@Transactional(readOnly = true)
	public long count(Filter... filters){
	     
	     return dao.count(filters);
	     
	}

	@Transactional(readOnly = true)
	public List<SystemVersion> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
	
		     return dao.findList(first,count,filters,orders);
	
	}
}