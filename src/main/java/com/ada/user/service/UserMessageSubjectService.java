package com.ada.user.service;

import com.ada.user.entity.UserMessageSubject;
import com.ada.user.page.UserMessageSubjectPage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


public interface UserMessageSubjectService {

	public UserMessageSubject findById(Long id);

	public UserMessageSubject save(UserMessageSubject bean);

	public UserMessageSubject update(UserMessageSubject bean);

	public UserMessageSubject deleteById(Long id);
	
	public UserMessageSubject[] deleteByIds(Long[] ids);
	
	public UserMessageSubjectPage getPage(int pageNo, int pageSize);
	
	
	public Page<UserMessageSubject> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<UserMessageSubject> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}