package com.ada.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.ada.site.dao.WebTemplateDao;
import com.ada.site.entity.WebTemplate;
import com.ada.site.service.WebTemplateService;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


@Service
@Transactional
public class WebTemplateServiceImpl implements WebTemplateService {
	

	@Transactional(readOnly = true)
	public WebTemplate findById(String id) {
		WebTemplate entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public WebTemplate save(WebTemplate bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public WebTemplate update(WebTemplate bean) {
		Updater<WebTemplate> updater = new Updater<WebTemplate>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public WebTemplate deleteById(String id) {
		WebTemplate bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public WebTemplate[] deleteByIds(String[] ids) {
		WebTemplate[] beans = new WebTemplate[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private WebTemplateDao dao;

	@Autowired
	public void setDao(WebTemplateDao dao) {
		this.dao = dao;
	}
	
	
	@Transactional(readOnly = true)
	public Page<WebTemplate> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	@Transactional(readOnly = true)
	public long count(Filter... filters){
	     
	     return dao.count(filters);
	     
	}

	@Transactional(readOnly = true)
	public List<WebTemplate> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
	
		     return dao.findList(first,count,filters,orders);
	
	}
}