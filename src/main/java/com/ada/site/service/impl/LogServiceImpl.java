package com.ada.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quhaodian.data.core.Finder;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;
import com.ada.site.dao.LogDao;
import com.ada.site.entity.Log;
import com.ada.site.service.LogService;
import com.ada.site.page.LogPage;

import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;


@Service
@Transactional
public class LogServiceImpl implements LogService {
	

	@Transactional(readOnly = true)
	public Log findById(Long id) {
		Log entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public Log save(Log bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public Log update(Log bean) {
		Updater<Log> updater = new Updater<Log>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public Log deleteById(Long id) {
		Log bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public Log[] deleteByIds(Long[] ids) {
		Log[] beans = new Log[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private LogDao dao;

	@Autowired
	public void setDao(LogDao dao) {
		this.dao = dao;
	}
	
	@Transactional(readOnly = true)
	public LogPage getPage(int pageNo, int pageSize) {
	    LogPage result = null;
		Finder finder=Finder.create();
		finder.append("from Log f ");
		finder.append(" order by f.id desc  ");
		Pagination<Log> page = dao.find(finder,pageNo, pageSize);
		result = new LogPage(page);
		return result;
	}
	
	
	@Transactional(readOnly = true)
	public Page<Log> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	@Transactional(readOnly = true)
	public long count(Filter... filters){
	     
	     return dao.count(filters);
	     
	}

	@Transactional(readOnly = true)
	public List<Log> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
	
		     return dao.findList(first,count,filters,orders);
	
	}
}