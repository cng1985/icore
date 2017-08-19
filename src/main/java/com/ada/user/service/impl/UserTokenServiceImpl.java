package com.ada.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.ada.user.dao.UserTokenDao;
import com.ada.user.entity.UserToken;
import com.ada.user.service.UserTokenService;
import com.ada.user.page.UserTokenPage;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


@Service
@Transactional
public class UserTokenServiceImpl implements UserTokenService {
	

	@Transactional(readOnly = true)
	public UserToken findById(Long id) {
		UserToken entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public UserToken save(UserToken bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public UserToken update(UserToken bean) {
		Updater<UserToken> updater = new Updater<UserToken>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public UserToken deleteById(Long id) {
		UserToken bean = dao.deleteById(id);
		dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public UserToken[] deleteByIds(Long[] ids) {
		UserToken[] beans = new UserToken[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private UserTokenDao dao;

	@Autowired
	public void setDao(UserTokenDao dao) {
		this.dao = dao;
	}
	
	@Transactional(readOnly = true)
	public UserTokenPage getPage(int pageNo, int pageSize) {
	    UserTokenPage result = null;
		Finder finder=Finder.create();
		finder.append("from UserToken f ");
		finder.append(" order by f.id desc  ");
		Pagination<UserToken> page = dao.find(finder,pageNo, pageSize);
		result = new UserTokenPage(page);
		return result;
	}
	
	
	public Page<UserToken> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	public long count(Filter... filters){
	     
	     return dao.count(filters);
	     
	}

	public List<UserToken> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
	
		     return dao.findList(first,count,filters,orders);
	
	}
}