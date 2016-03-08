package com.ada.activity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.activity.dao.ActivityCatalogDao;
import com.ada.activity.dao.ActivityDao;
import com.ada.activity.entity.Activity;
import com.ada.activity.entity.ActivityCatalog;
import com.ada.activity.page.ActivityPage;
import com.ada.activity.service.ActivityService;
import com.ada.article.entity.ArticleCatalog;
import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;


@Service
@Transactional
public class ActivityServiceImpl implements ActivityService {
	

	@Transactional(readOnly = true)
	public Activity findById(Long id) {
		Activity entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public Activity save(Activity bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public Activity update(Activity bean) {
		Updater<Activity> updater = new Updater<Activity>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public Activity deleteById(Long id) {
		Activity bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public Activity[] deleteByIds(Long[] ids) {
		Activity[] beans = new Activity[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private ActivityDao dao;
	
	private ActivityCatalogDao catalogDao;

	@Autowired
	public void setDao(ActivityDao dao) {
		this.dao = dao;
	}
	
	@Transactional(readOnly = true)
	public ActivityPage getPage(int pageNo, int pageSize) {
	    ActivityPage result = null;
		Finder finder=Finder.create();
		finder.append("from Activity f ");
		finder.append(" order by f.id desc  ");
		Pagination<Activity> page = dao.find(finder,pageNo, pageSize);
		result = new ActivityPage(page);
		return result;
	}
	
	
	@Transactional(readOnly = true)
	public Page<Activity> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	@Transactional(readOnly = true)
	public long count(Filter... filters){
	     
	     return dao.count(filters);
	     
	}

	@Transactional(readOnly = true)
	public List<Activity> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
	
		     return dao.findList(first,count,filters,orders);
	
	}

	@Override
	public ActivityPage pageByCatalog(int id, int curpage, int pagesize) {
		ActivityPage result = null;

		ActivityCatalog catalogs = catalogDao.findById(id);
		if (catalogs != null) {
			Finder finder = Finder.create();
			finder.append("from Activity a where a.catalog.lft >= :lft ");
			finder.setParam("lft", catalogs.getLft());
			finder.append(" and a.catalog.rgt <= :rgt");
			finder.setParam("rgt", catalogs.getRgt());
			Pagination<Activity> page = dao.find(finder, curpage, pagesize);
			result = new ActivityPage(page);
		}
		return result;
	}
}