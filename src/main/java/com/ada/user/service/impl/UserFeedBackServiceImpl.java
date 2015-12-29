package com.ada.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.ada.user.dao.UserFeedBackDao;
import com.ada.user.entity.UserFeedBack;
import com.ada.user.service.UserFeedBackService;
import com.ada.user.page.UserFeedBackPage;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


@Service
@Transactional
public class UserFeedBackServiceImpl implements UserFeedBackService {
	

	@Transactional(readOnly = true)
	public UserFeedBack findById(Long id) {
		UserFeedBack entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public UserFeedBack save(UserFeedBack bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public UserFeedBack update(UserFeedBack bean) {
		Updater<UserFeedBack> updater = new Updater<UserFeedBack>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public UserFeedBack deleteById(Long id) {
		UserFeedBack bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public UserFeedBack[] deleteByIds(Long[] ids) {
		UserFeedBack[] beans = new UserFeedBack[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private UserFeedBackDao dao;

	@Autowired
	public void setDao(UserFeedBackDao dao) {
		this.dao = dao;
	}
	
	@Transactional(readOnly = true)
	public UserFeedBackPage getPage(int pageNo, int pageSize) {
	    UserFeedBackPage result = null;
		Finder finder=Finder.create();
		finder.append("from UserFeedBack f ");
		finder.append(" order by f.id desc  ");
		Pagination<UserFeedBack> page = dao.find(finder,pageNo, pageSize);
		result = new UserFeedBackPage(page);
		return result;
	}
	
	
	public Page<UserFeedBack> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	public long count(Filter... filters){
	     
	     return dao.count(filters);
	     
	}

	public List<UserFeedBack> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
	
		     return dao.findList(first,count,filters,orders);
	
	}
}