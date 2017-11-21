package com.ada.user.service;

import com.ada.user.entity.UserMessageSubject;
import com.ada.user.page.UserMessageSubjectPage;
import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;

public interface UserMessageSubjectService {

	UserMessageSubject findById(Long id);

	UserMessageSubject save(UserMessageSubject bean);

	UserMessageSubject update(UserMessageSubject bean);

	UserMessageSubject deleteById(Long id);
	
	UserMessageSubject[] deleteByIds(Long[] ids);
	
	UserMessageSubjectPage getPage(int pageNo, int pageSize);
	
	
	Page<UserMessageSubject> findPage(Pageable pageable);

	long count(Filter... filters);

	List<UserMessageSubject> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}