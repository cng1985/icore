package com.ada.article.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.ada.article.dao.SensitiveCategoryDao;
import com.ada.article.entity.SensitiveCategory;
import com.ada.article.service.SensitiveCategoryService;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


@Service
@Transactional
public class SensitiveCategoryServiceImpl implements SensitiveCategoryService {
	

	@Transactional(readOnly = true)
	public SensitiveCategory findById(Integer id) {
		SensitiveCategory entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public SensitiveCategory save(SensitiveCategory bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public SensitiveCategory update(SensitiveCategory bean) {
		Updater<SensitiveCategory> updater = new Updater<SensitiveCategory>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public SensitiveCategory deleteById(Integer id) {
		SensitiveCategory bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public SensitiveCategory[] deleteByIds(Integer[] ids) {
		SensitiveCategory[] beans = new SensitiveCategory[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private SensitiveCategoryDao dao;

	@Autowired
	public void setDao(SensitiveCategoryDao dao) {
		this.dao = dao;
	}
	
	
	@Transactional(readOnly = true)
	public Page<SensitiveCategory> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	@Transactional(readOnly = true)
	public long count(Filter... filters){
	     
	     return dao.count(filters);
	     
	}

	@Transactional(readOnly = true)
	public List<SensitiveCategory> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
	
		     return dao.findList(first,count,filters,orders);
	
	}
}