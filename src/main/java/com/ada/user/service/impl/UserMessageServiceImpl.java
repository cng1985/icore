package com.ada.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quhaodian.data.core.Finder;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;
import com.ada.user.dao.UserMessageDao;
import com.ada.user.entity.UserMessage;
import com.ada.user.service.UserMessageService;
import com.ada.user.page.UserMessagePage;

import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;


@Service
@Transactional
public class UserMessageServiceImpl implements UserMessageService {
	

	@Transactional(readOnly = true)
	public UserMessage findById(Long id) {
		UserMessage entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public UserMessage save(UserMessage bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public UserMessage update(UserMessage bean) {
		Updater<UserMessage> updater = new Updater<UserMessage>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public UserMessage deleteById(Long id) {
		UserMessage bean = dao.deleteById(id);
		dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public UserMessage[] deleteByIds(Long[] ids) {
		UserMessage[] beans = new UserMessage[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private UserMessageDao dao;

	@Autowired
	public void setDao(UserMessageDao dao) {
		this.dao = dao;
	}
	
	@Transactional(readOnly = true)
	public UserMessagePage getPage(int pageNo, int pageSize) {
	    UserMessagePage result = null;
		Finder finder=Finder.create();
		finder.append("from UserMessage f ");
		finder.append(" order by f.id desc  ");
		Pagination<UserMessage> page = dao.find(finder,pageNo, pageSize);
		result = new UserMessagePage(page);
		return result;
	}
	
	
	@Transactional(readOnly = true)
	public Page<UserMessage> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	@Transactional(readOnly = true)
	public long count(Filter... filters){
	     
	     return dao.count(filters);
	     
	}

	@Transactional(readOnly = true)
	public List<UserMessage> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
	
		     return dao.findList(first,count,filters,orders);
	
	}
}