package com.ada.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.ada.user.dao.UserNotificationNumDao;
import com.ada.user.entity.UserNotificationNum;
import com.ada.user.service.UserNotificationNumService;
import com.ada.user.page.UserNotificationNumPage;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


@Service
@Transactional
public class UserNotificationNumServiceImpl implements UserNotificationNumService {
	

	@Transactional(readOnly = true)
	public UserNotificationNum findById(Long id) {
		UserNotificationNum entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public UserNotificationNum save(UserNotificationNum bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public UserNotificationNum update(UserNotificationNum bean) {
		Updater<UserNotificationNum> updater = new Updater<UserNotificationNum>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public UserNotificationNum deleteById(Long id) {
		UserNotificationNum bean = dao.deleteById(id);
		dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public UserNotificationNum[] deleteByIds(Long[] ids) {
		UserNotificationNum[] beans = new UserNotificationNum[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private UserNotificationNumDao dao;

	@Autowired
	public void setDao(UserNotificationNumDao dao) {
		this.dao = dao;
	}
	
	@Transactional(readOnly = true)
	public UserNotificationNumPage getPage(int pageNo, int pageSize) {
	    UserNotificationNumPage result = null;
		Finder finder=Finder.create();
		finder.append("from UserNotificationNum f ");
		finder.append(" order by f.id desc  ");
		Pagination<UserNotificationNum> page = dao.find(finder,pageNo, pageSize);
		result = new UserNotificationNumPage(page);
		return result;
	}
	
	
	@Transactional(readOnly = true)
	public Page<UserNotificationNum> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	@Transactional(readOnly = true)
	public long count(Filter... filters){
	     
	     return dao.count(filters);
	     
	}

	@Transactional(readOnly = true)
	public List<UserNotificationNum> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
	
		     return dao.findList(first,count,filters,orders);
	
	}
}