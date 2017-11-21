package com.ada.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quhaodian.data.core.Finder;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;
import com.ada.user.dao.UserRoleDao;
import com.ada.user.entity.UserRole;
import com.ada.user.service.UserRoleService;
import com.ada.user.page.UserRolePage;

import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;


@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService {
	

	@Transactional(readOnly = true)
	public UserRole findById(Long id) {
		UserRole entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public UserRole save(UserRole bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public UserRole update(UserRole bean) {
		Updater<UserRole> updater = new Updater<UserRole>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public UserRole deleteById(Long id) {
		UserRole bean = dao.deleteById(id);
		dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public UserRole[] deleteByIds(Long[] ids) {
		UserRole[] beans = new UserRole[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private UserRoleDao dao;

	@Autowired
	public void setDao(UserRoleDao dao) {
		this.dao = dao;
	}
	
	@Transactional(readOnly = true)
	public UserRolePage getPage(int pageNo, int pageSize) {
	    UserRolePage result = null;
		Finder finder=Finder.create();
		finder.append("from UserRole f ");
		finder.append(" order by f.id desc  ");
		Pagination<UserRole> page = dao.find(finder,pageNo, pageSize);
		result = new UserRolePage(page);
		return result;
	}
	
	@Transactional(readOnly = true)
	public Page<UserRole> findPage(Pageable pageable){
		Page<UserRole>  us= dao.findPage(pageable);
//		List<UserRole>  uss=	us.getContent();
//		for (UserRole userRole : uss) {
//			userRole.getAuthorities();
//		}
		return us;
	}

	@Transactional(readOnly = true)
	public long count(Filter... filters){
	     
	     return dao.count(filters);
	     
	}

	@Transactional(readOnly = true)
	public List<UserRole> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
	
		     return dao.findList(first,count,filters,orders);
	
	}
}