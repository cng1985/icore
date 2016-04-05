package com.ada.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.ada.site.dao.AppDao;
import com.ada.site.entity.App;
import com.ada.site.service.AppService;
import com.ada.site.page.AppPage;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


@Service
@Transactional
public class AppServiceImpl implements AppService {
	

	@Transactional(readOnly = true)
	public App findById(Long id) {
		App entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public App save(App bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public App update(App bean) {
		Updater<App> updater = new Updater<App>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public App deleteById(Long id) {
		App bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public App[] deleteByIds(Long[] ids) {
		App[] beans = new App[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private AppDao dao;

	@Autowired
	public void setDao(AppDao dao) {
		this.dao = dao;
	}
	
	@Transactional(readOnly = true)
	public AppPage getPage(int pageNo, int pageSize) {
	    AppPage result = null;
		Finder finder=Finder.create();
		finder.append("from App f ");
		finder.append(" order by f.id desc  ");
		Pagination<App> page = dao.find(finder,pageNo, pageSize);
		result = new AppPage(page);
		return result;
	}
	
	
	@Transactional(readOnly = true)
	public Page<App> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	@Transactional(readOnly = true)
	public long count(Filter... filters){
	     
	     return dao.count(filters);
	     
	}

	@Transactional(readOnly = true)
	public List<App> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
	
		     return dao.findList(first,count,filters,orders);
	
	}
}