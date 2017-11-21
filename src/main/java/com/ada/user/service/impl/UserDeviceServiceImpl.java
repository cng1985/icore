package com.ada.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quhaodian.data.core.Finder;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;
import com.ada.user.dao.UserDeviceDao;
import com.ada.user.entity.UserDevice;
import com.ada.user.service.UserDeviceService;
import com.ada.user.page.UserDevicePage;

import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;


@Service
@Transactional
public class UserDeviceServiceImpl implements UserDeviceService {
	

	@Transactional(readOnly = true)
	public UserDevice findById(Long id) {
		UserDevice entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public UserDevice save(UserDevice bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public UserDevice update(UserDevice bean) {
		Updater<UserDevice> updater = new Updater<UserDevice>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public UserDevice deleteById(Long id) {
		UserDevice bean = dao.deleteById(id);
		dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public UserDevice[] deleteByIds(Long[] ids) {
		UserDevice[] beans = new UserDevice[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private UserDeviceDao dao;

	@Autowired
	public void setDao(UserDeviceDao dao) {
		this.dao = dao;
	}
	
	@Transactional(readOnly = true)
	public UserDevicePage getPage(int pageNo, int pageSize) {
	    UserDevicePage result = null;
		Finder finder=Finder.create();
		finder.append("from UserDevice f ");
		finder.append(" order by f.id desc  ");
		Pagination<UserDevice> page = dao.find(finder,pageNo, pageSize);
		result = new UserDevicePage(page);
		return result;
	}
	
	
	public Page<UserDevice> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	public long count(Filter... filters){
	     
	     return dao.count(filters);
	     
	}

	public List<UserDevice> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
	
		     return dao.findList(first,count,filters,orders);
	
	}
}