package com.ada.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.ada.user.dao.UserMessageMemberDao;
import com.ada.user.entity.UserMessageMember;
import com.ada.user.service.UserMessageMemberService;
import com.ada.user.page.UserMessageMemberPage;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


@Service
@Transactional
public class UserMessageMemberServiceImpl implements UserMessageMemberService {
	

	@Transactional(readOnly = true)
	public UserMessageMember findById(Long id) {
		UserMessageMember entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public UserMessageMember save(UserMessageMember bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public UserMessageMember update(UserMessageMember bean) {
		Updater<UserMessageMember> updater = new Updater<UserMessageMember>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public UserMessageMember deleteById(Long id) {
		UserMessageMember bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public UserMessageMember[] deleteByIds(Long[] ids) {
		UserMessageMember[] beans = new UserMessageMember[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private UserMessageMemberDao dao;

	@Autowired
	public void setDao(UserMessageMemberDao dao) {
		this.dao = dao;
	}
	
	@Transactional(readOnly = true)
	public UserMessageMemberPage getPage(int pageNo, int pageSize) {
	    UserMessageMemberPage result = null;
		Finder finder=Finder.create();
		finder.append("from UserMessageMember f ");
		finder.append(" order by f.id desc  ");
		Pagination<UserMessageMember> page = dao.find(finder,pageNo, pageSize);
		result = new UserMessageMemberPage(page);
		return result;
	}
	
	
	@Transactional(readOnly = true)
	public Page<UserMessageMember> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	@Transactional(readOnly = true)
	public long count(Filter... filters){
	     
	     return dao.count(filters);
	     
	}

	@Transactional(readOnly = true)
	public List<UserMessageMember> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
	
		     return dao.findList(first,count,filters,orders);
	
	}
}