package com.ada.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.ada.user.dao.UserNotificationCatalogDao;
import com.ada.user.entity.UserNotificationCatalog;
import com.ada.user.service.UserNotificationCatalogService;
import com.ada.user.page.UserNotificationCatalogPage;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


@Service
@Transactional
public class UserNotificationCatalogServiceImpl implements UserNotificationCatalogService {
	

	@Transactional(readOnly = true)
	public UserNotificationCatalog findById(Integer id) {
		UserNotificationCatalog entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public UserNotificationCatalog save(UserNotificationCatalog bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public UserNotificationCatalog update(UserNotificationCatalog bean) {
		Updater<UserNotificationCatalog> updater = new Updater<UserNotificationCatalog>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public UserNotificationCatalog deleteById(Integer id) {
		UserNotificationCatalog bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public UserNotificationCatalog[] deleteByIds(Integer[] ids) {
		UserNotificationCatalog[] beans = new UserNotificationCatalog[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private UserNotificationCatalogDao dao;

	@Autowired
	public void setDao(UserNotificationCatalogDao dao) {
		this.dao = dao;
	}
	
	@Transactional(readOnly = true)
	public UserNotificationCatalogPage getPage(int pageNo, int pageSize) {
	    UserNotificationCatalogPage result = null;
		Finder finder=Finder.create();
		finder.append("from UserNotificationCatalog f ");
		finder.append(" order by f.id desc  ");
		Pagination<UserNotificationCatalog> page = dao.find(finder,pageNo, pageSize);
		result = new UserNotificationCatalogPage(page);
		return result;
	}
	
	
	@Transactional(readOnly = true)
	public Page<UserNotificationCatalog> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	@Transactional(readOnly = true)
	public long count(Filter... filters){
	     
	     return dao.count(filters);
	     
	}

	@Transactional(readOnly = true)
	public List<UserNotificationCatalog> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
	
		     return dao.findList(first,count,filters,orders);
	
	}
}