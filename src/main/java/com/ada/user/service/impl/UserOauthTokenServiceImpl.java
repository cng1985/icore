package com.ada.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.ada.user.dao.UserOauthTokenDao;
import com.ada.user.entity.UserOauthToken;
import com.ada.user.service.UserOauthTokenService;
import com.ada.user.page.UserOauthTokenPage;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


@Service
@Transactional
public class UserOauthTokenServiceImpl implements UserOauthTokenService {
	

	@Transactional(readOnly = true)
	public UserOauthToken findById(Long id) {
		UserOauthToken entity = dao.findById(id);
		return entity;
	}

	@Override
	public UserOauthToken findByUid(String uid) {


		Finder finder=Finder.create();
		finder.append("from UserOauthToken u where u.uid=:uid");
		finder.setParam("uid",uid);
		return dao.findOne(finder);
	}

	@Transactional
	public UserOauthToken save(UserOauthToken bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public UserOauthToken update(UserOauthToken bean) {
		Updater<UserOauthToken> updater = new Updater<UserOauthToken>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public UserOauthToken deleteById(Long id) {
		UserOauthToken bean = dao.deleteById(id);
		dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public UserOauthToken[] deleteByIds(Long[] ids) {
		UserOauthToken[] beans = new UserOauthToken[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private UserOauthTokenDao dao;

	@Autowired
	public void setDao(UserOauthTokenDao dao) {
		this.dao = dao;
	}
	
	@Transactional(readOnly = true)
	public UserOauthTokenPage getPage(int pageNo, int pageSize) {
	    UserOauthTokenPage result = null;
		Finder finder=Finder.create();
		finder.append("from UserOauthToken f ");
		finder.append(" order by f.id desc  ");
		Pagination<UserOauthToken> page = dao.find(finder,pageNo, pageSize);
		result = new UserOauthTokenPage(page);
		return result;
	}
	
	
	@Transactional(readOnly = true)
	public Page<UserOauthToken> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	@Transactional(readOnly = true)
	public long count(Filter... filters){
	     
	     return dao.count(filters);
	     
	}

	@Transactional(readOnly = true)
	public List<UserOauthToken> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
	
		     return dao.findList(first,count,filters,orders);
	
	}
}