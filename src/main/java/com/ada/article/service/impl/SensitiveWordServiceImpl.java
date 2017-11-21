package com.ada.article.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quhaodian.data.core.Finder;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;
import com.ada.article.dao.SensitiveWordDao;
import com.ada.article.entity.SensitiveWord;
import com.ada.article.service.SensitiveWordService;

import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;


@Service
@Transactional
public class SensitiveWordServiceImpl implements SensitiveWordService {
	

	@Transactional(readOnly = true)
	public SensitiveWord findById(Long id) {
		SensitiveWord entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public SensitiveWord save(SensitiveWord bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public SensitiveWord update(SensitiveWord bean) {
		Updater<SensitiveWord> updater = new Updater<SensitiveWord>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public SensitiveWord deleteById(Long id) {
		SensitiveWord bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public SensitiveWord[] deleteByIds(Long[] ids) {
		SensitiveWord[] beans = new SensitiveWord[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private SensitiveWordDao dao;

	@Autowired
	public void setDao(SensitiveWordDao dao) {
		this.dao = dao;
	}
	
	
	@Transactional(readOnly = true)
	public Page<SensitiveWord> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	@Transactional(readOnly = true)
	public long count(Filter... filters){
	     
	     return dao.count(filters);
	     
	}

	@Transactional(readOnly = true)
	public List<SensitiveWord> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
	
		     return dao.findList(first,count,filters,orders);
	
	}
}