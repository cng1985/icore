package com.ada.activity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.ada.activity.dao.ActivityCatalogDao;
import com.ada.activity.entity.ActivityCatalog;
import com.ada.activity.service.ActivityCatalogService;
import com.ada.activity.page.ActivityCatalogPage;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


@Service
@Transactional
public class ActivityCatalogServiceImpl implements ActivityCatalogService {
	

	@Transactional(readOnly = true)
	public ActivityCatalog findById(Integer id) {
		ActivityCatalog entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public ActivityCatalog save(ActivityCatalog bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public ActivityCatalog update(ActivityCatalog bean) {
		Updater<ActivityCatalog> updater = new Updater<ActivityCatalog>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public ActivityCatalog deleteById(Integer id) {
		ActivityCatalog bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public ActivityCatalog[] deleteByIds(Integer[] ids) {
		ActivityCatalog[] beans = new ActivityCatalog[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private ActivityCatalogDao dao;

	@Autowired
	public void setDao(ActivityCatalogDao dao) {
		this.dao = dao;
	}
	
	@Transactional(readOnly = true)
	public ActivityCatalogPage getPage(int pageNo, int pageSize) {
	    ActivityCatalogPage result = null;
		Finder finder=Finder.create();
		finder.append("from ActivityCatalog f ");
		finder.append(" order by f.id desc  ");
		Pagination<ActivityCatalog> page = dao.find(finder,pageNo, pageSize);
		result = new ActivityCatalogPage(page);
		return result;
	}
	
	
	@Transactional(readOnly = true)
	public Page<ActivityCatalog> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	@Transactional(readOnly = true)
	public long count(Filter... filters){
	     
	     return dao.count(filters);
	     
	}

	@Transactional(readOnly = true)
	public List<ActivityCatalog> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
	
		     return dao.findList(first,count,filters,orders);
	
	}

	@Override
	public List<ActivityCatalog> findChild(int id) {
		Finder finder = Finder.create("from ActivityCatalog t where t.parent.id=" + id);
		finder.append(" order by t.sortnum asc");
		finder.setCacheable(true);
		return dao.find(finder);
	}
}