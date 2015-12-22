package com.ada.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.ada.user.dao.UserVerificationDao;
import com.ada.user.entity.UserVerification;
import com.ada.user.service.UserVerificationService;
import com.ada.user.page.UserVerificationPage;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


@Service
@Transactional
public class UserVerificationServiceImpl implements UserVerificationService {
	

	@Transactional(readOnly = true)
	public UserVerification findById(Long id) {
		UserVerification entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public UserVerification save(UserVerification bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public UserVerification update(UserVerification bean) {
		Updater<UserVerification> updater = new Updater<UserVerification>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public UserVerification deleteById(Long id) {
		UserVerification bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public UserVerification[] deleteByIds(Long[] ids) {
		UserVerification[] beans = new UserVerification[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private UserVerificationDao dao;

	@Autowired
	public void setDao(UserVerificationDao dao) {
		this.dao = dao;
	}
	
	@Transactional(readOnly = true)
	public UserVerificationPage getPage(int pageNo, int pageSize) {
	    UserVerificationPage result = null;
		Finder finder=Finder.create();
		finder.append("from UserVerification f ");
		finder.append(" order by f.id desc  ");
		Pagination<UserVerification> page = dao.find(finder,pageNo, pageSize);
		result = new UserVerificationPage(page);
		return result;
	}
	
	
	public Page<UserVerification> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	public long count(Filter... filters){
	     
	     return dao.count(filters);
	     
	}

	public List<UserVerification> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
	
		     return dao.findList(first,count,filters,orders);
	
	}
}