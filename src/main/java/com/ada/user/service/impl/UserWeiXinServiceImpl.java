package com.ada.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quhaodian.data.core.Finder;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;
import com.ada.user.dao.UserWeiXinDao;
import com.ada.user.entity.UserQQ;
import com.ada.user.entity.UserWeiXin;
import com.ada.user.service.UserWeiXinService;
import com.ada.user.page.UserWeiXinPage;

import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;


@Service
@Transactional
public class UserWeiXinServiceImpl implements UserWeiXinService {
	

	@Transactional(readOnly = true)
	public UserWeiXin findById(Long id) {
		UserWeiXin entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public UserWeiXin save(UserWeiXin bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public UserWeiXin update(UserWeiXin bean) {
		Updater<UserWeiXin> updater = new Updater<UserWeiXin>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public UserWeiXin deleteById(Long id) {
		UserWeiXin bean = dao.deleteById(id);
		dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public UserWeiXin[] deleteByIds(Long[] ids) {
		UserWeiXin[] beans = new UserWeiXin[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private UserWeiXinDao dao;

	@Autowired
	public void setDao(UserWeiXinDao dao) {
		this.dao = dao;
	}
	
	@Transactional(readOnly = true)
	public UserWeiXinPage getPage(int pageNo, int pageSize) {
	    UserWeiXinPage result = null;
		Finder finder=Finder.create();
		finder.append("from UserWeiXin f ");
		finder.append(" order by f.id desc  ");
		Pagination<UserWeiXin> page = dao.find(finder,pageNo, pageSize);
		result = new UserWeiXinPage(page);
		return result;
	}
	
	
	@Transactional(readOnly = true)
	public Page<UserWeiXin> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	@Transactional(readOnly = true)
	public long count(Filter... filters){
	     
	     return dao.count(filters);
	     
	}

	@Transactional(readOnly = true)
	public List<UserWeiXin> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
	
		     return dao.findList(first,count,filters,orders);
	
	}

	@Override
	public UserQQ login(String access_token, String openid) {
		// TODO Auto-generated method stub
		return null;
	}
}