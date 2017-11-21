package com.ada.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quhaodian.data.core.Finder;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;
import com.ada.user.dao.UserNotificationTimeDao;
import com.ada.user.entity.UserNotificationTime;
import com.ada.user.service.UserNotificationTimeService;
import com.ada.user.page.UserNotificationTimePage;

import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;


@Service
@Transactional
public class UserNotificationTimeServiceImpl implements UserNotificationTimeService {
	

	@Transactional(readOnly = true)
	public UserNotificationTime findById(Long id) {
		UserNotificationTime entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public UserNotificationTime save(UserNotificationTime bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public UserNotificationTime update(UserNotificationTime bean) {
		Updater<UserNotificationTime> updater = new Updater<UserNotificationTime>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public UserNotificationTime deleteById(Long id) {
		UserNotificationTime bean = dao.deleteById(id);
		dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public UserNotificationTime[] deleteByIds(Long[] ids) {
		UserNotificationTime[] beans = new UserNotificationTime[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private UserNotificationTimeDao dao;

	@Autowired
	public void setDao(UserNotificationTimeDao dao) {
		this.dao = dao;
	}
	
	@Transactional(readOnly = true)
	public UserNotificationTimePage getPage(int pageNo, int pageSize) {
	    UserNotificationTimePage result = null;
		Finder finder=Finder.create();
		finder.append("from UserNotificationTime f ");
		finder.append(" order by f.id desc  ");
		Pagination<UserNotificationTime> page = dao.find(finder,pageNo, pageSize);
		result = new UserNotificationTimePage(page);
		return result;
	}
	
	
	@Transactional(readOnly = true)
	public Page<UserNotificationTime> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	@Transactional(readOnly = true)
	public long count(Filter... filters){
	     
	     return dao.count(filters);
	     
	}

	@Transactional(readOnly = true)
	public List<UserNotificationTime> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
	
		     return dao.findList(first,count,filters,orders);
	
	}
}