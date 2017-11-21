package com.ada.activity.service.impl;

import com.quhaodian.data.core.Finder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quhaodian.data.core.Updater;
import com.ada.activity.dao.ActivityCatalogDao;
import com.ada.activity.entity.ActivityCatalog;
import com.ada.activity.service.ActivityCatalogService;

import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;
import java.util.LinkedList;
import com.quhaodian.data.utils.FilterUtils;


/**
* Created by imake on 2017年05月30日09:14:00.
*/
@Service
@Transactional
public class ActivityCatalogServiceImpl implements ActivityCatalogService {

	private ActivityCatalogDao dao;


	@Override
	@Transactional(readOnly = true)
	public ActivityCatalog findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public List<ActivityCatalog> findByTops(Integer pid) {
		LinkedList<ActivityCatalog> result = new LinkedList<ActivityCatalog>();
		ActivityCatalog catalog = dao.findById(pid);
	    if(catalog != null){
			while ( catalog != null && catalog.getParent() != null ) {
				result.addFirst(catalog);
				catalog = dao.findById(catalog.getParentId());
			}
			result.addFirst(catalog);
	    }
		return result;
	}

	@Override
    @Transactional
	public ActivityCatalog save(ActivityCatalog bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public ActivityCatalog update(ActivityCatalog bean) {
		Updater<ActivityCatalog> updater = new Updater<ActivityCatalog>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public ActivityCatalog deleteById(Integer id) {
		ActivityCatalog bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public ActivityCatalog[] deleteByIds(Integer[] ids) {
		ActivityCatalog[] beans = new ActivityCatalog[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(ActivityCatalogDao dao) {
		this.dao = dao;
	}

	@Override
	@Transactional(readOnly = true)
	public Page<ActivityCatalog> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	@Override
    public Page<ActivityCatalog> page(Pageable pageable){
         return dao.page(pageable);
    }

	@Override
	@Transactional(readOnly = true)
	public long count(Filter... filters){
	     return dao.count(filters);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ActivityCatalog> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
		return dao.findList(first,count,filters,orders);
	}

    @Override
	public Page<ActivityCatalog> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}
	@Transactional(readOnly = true)
	@Override
	public List<ActivityCatalog> findChild(int id) {
		Finder finder = Finder.create("from ActivityCatalog t where t.parent.id=" + id);
		finder.append(" order by t.sortNum asc");
		finder.setCacheable(true);
		return dao.find(finder);
	}
}