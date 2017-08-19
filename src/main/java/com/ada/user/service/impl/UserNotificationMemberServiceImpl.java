package com.ada.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.ada.user.dao.UserNotificationMemberDao;
import com.ada.user.entity.UserNotificationMember;
import com.ada.user.service.UserNotificationMemberService;
import com.ada.user.page.UserNotificationMemberPage;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


@Service
@Transactional
public class UserNotificationMemberServiceImpl implements UserNotificationMemberService {
	

	@Transactional(readOnly = true)
	public UserNotificationMember findById(Long id) {
		UserNotificationMember entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public UserNotificationMember save(UserNotificationMember bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public UserNotificationMember update(UserNotificationMember bean) {
		Updater<UserNotificationMember> updater = new Updater<UserNotificationMember>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public UserNotificationMember deleteById(Long id) {
		UserNotificationMember bean = dao.deleteById(id);
		dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public UserNotificationMember[] deleteByIds(Long[] ids) {
		UserNotificationMember[] beans = new UserNotificationMember[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private UserNotificationMemberDao dao;

	@Autowired
	public void setDao(UserNotificationMemberDao dao) {
		this.dao = dao;
	}
	
	@Transactional(readOnly = true)
	public UserNotificationMemberPage getPage(int pageNo, int pageSize) {
	    UserNotificationMemberPage result = null;
		Finder finder=Finder.create();
		finder.append("from UserNotificationMember f ");
		finder.append(" order by f.id desc  ");
		Pagination<UserNotificationMember> page = dao.find(finder,pageNo, pageSize);
		result = new UserNotificationMemberPage(page);
		return result;
	}
	
	
	@Transactional(readOnly = true)
	public Page<UserNotificationMember> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	@Transactional(readOnly = true)
	public long count(Filter... filters){
	     
	     return dao.count(filters);
	     
	}

	@Transactional(readOnly = true)
	public List<UserNotificationMember> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
	
		     return dao.findList(first,count,filters,orders);
	
	}
}