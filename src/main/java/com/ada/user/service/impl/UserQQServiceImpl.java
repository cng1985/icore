package com.ada.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quhaodian.data.core.Finder;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;
import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import com.ada.user.dao.UserQQDao;
import com.ada.user.entity.UserQQ;
import com.ada.user.page.UserQQPage;
import com.ada.user.service.UserQQService;


@Service
@Transactional
public class UserQQServiceImpl implements UserQQService {
	

	@Transactional(readOnly = true)
	public UserQQ findById(Long id) {
		UserQQ entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public UserQQ save(UserQQ bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public UserQQ update(UserQQ bean) {
		Updater<UserQQ> updater = new Updater<UserQQ>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public UserQQ deleteById(Long id) {
		UserQQ bean = dao.deleteById(id);
		dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public UserQQ[] deleteByIds(Long[] ids) {
		UserQQ[] beans = new UserQQ[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private UserQQDao dao;

	@Autowired
	public void setDao(UserQQDao dao) {
		this.dao = dao;
	}
	
	@Transactional(readOnly = true)
	public UserQQPage getPage(int pageNo, int pageSize) {
	    UserQQPage result = null;
		Finder finder=Finder.create();
		finder.append("from UserQQ f ");
		finder.append(" order by f.id desc  ");
		Pagination<UserQQ> page = dao.find(finder,pageNo, pageSize);
		result = new UserQQPage(page);
		return result;
	}
	
	
	@Transactional(readOnly = true)
	public Page<UserQQ> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	@Transactional(readOnly = true)
	public long count(Filter... filters){
	     
	     return dao.count(filters);
	     
	}

	@Transactional(readOnly = true)
	public List<UserQQ> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
	
		     return dao.findList(first,count,filters,orders);
	
	}
	
	@Transactional
	@Override
	public UserQQ login(String access_token, String openid, String oauth_consumer_key) throws Exception {
		// TODO Auto-generated method stub
		return dao.login(access_token, openid, oauth_consumer_key);
	}
}