package com.ada.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.ada.user.dao.UserMessageSubjectDao;
import com.ada.user.entity.UserMessageSubject;
import com.ada.user.service.UserMessageSubjectService;
import com.ada.user.page.UserMessageSubjectPage;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


@Service
@Transactional
public class UserMessageSubjectServiceImpl implements UserMessageSubjectService {
	

	@Transactional(readOnly = true)
	public UserMessageSubject findById(Long id) {
		UserMessageSubject entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public UserMessageSubject save(UserMessageSubject bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public UserMessageSubject update(UserMessageSubject bean) {
		Updater<UserMessageSubject> updater = new Updater<UserMessageSubject>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public UserMessageSubject deleteById(Long id) {
		UserMessageSubject bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public UserMessageSubject[] deleteByIds(Long[] ids) {
		UserMessageSubject[] beans = new UserMessageSubject[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private UserMessageSubjectDao dao;

	@Autowired
	public void setDao(UserMessageSubjectDao dao) {
		this.dao = dao;
	}
	
	@Transactional(readOnly = true)
	public UserMessageSubjectPage getPage(int pageNo, int pageSize) {
	    UserMessageSubjectPage result = null;
		Finder finder=Finder.create();
		finder.append("from UserMessageSubject f ");
		finder.append(" order by f.id desc  ");
		Pagination<UserMessageSubject> page = dao.find(finder,pageNo, pageSize);
		result = new UserMessageSubjectPage(page);
		return result;
	}
	
	
	@Transactional(readOnly = true)
	public Page<UserMessageSubject> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	@Transactional(readOnly = true)
	public long count(Filter... filters){
	     
	     return dao.count(filters);
	     
	}

	@Transactional(readOnly = true)
	public List<UserMessageSubject> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
	
		     return dao.findList(first,count,filters,orders);
	
	}
}