package com.ada.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.ada.site.dao.TemplatePushDao;
import com.ada.site.entity.TemplatePush;
import com.ada.site.service.TemplatePushService;
import com.ada.site.page.TemplatePushPage;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


@Service
@Transactional
public class TemplatePushServiceImpl implements TemplatePushService {
	

	@Transactional(readOnly = true)
	public TemplatePush findById(String id) {
		TemplatePush entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public TemplatePush save(TemplatePush bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public TemplatePush update(TemplatePush bean) {
		Updater<TemplatePush> updater = new Updater<TemplatePush>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public TemplatePush deleteById(String id) {
		TemplatePush bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public TemplatePush[] deleteByIds(String[] ids) {
		TemplatePush[] beans = new TemplatePush[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private TemplatePushDao dao;

	@Autowired
	public void setDao(TemplatePushDao dao) {
		this.dao = dao;
	}
	
	@Transactional(readOnly = true)
	public TemplatePushPage getPage(int pageNo, int pageSize) {
	    TemplatePushPage result = null;
		Finder finder=Finder.create();
		finder.append("from TemplatePush f ");
		finder.append(" order by f.id desc  ");
		Pagination<TemplatePush> page = dao.find(finder,pageNo, pageSize);
		result = new TemplatePushPage(page);
		return result;
	}
	
	
	@Transactional(readOnly = true)
	public Page<TemplatePush> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	@Transactional(readOnly = true)
	public long count(Filter... filters){
	     
	     return dao.count(filters);
	     
	}

	@Transactional(readOnly = true)
	public List<TemplatePush> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
	
		     return dao.findList(first,count,filters,orders);
	
	}
}