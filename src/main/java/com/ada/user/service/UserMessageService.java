package com.ada.user.service;

import com.ada.user.entity.UserMessage;
import com.ada.user.page.UserMessagePage;
import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;

public interface UserMessageService {

	UserMessage findById(Long id);

	UserMessage save(UserMessage bean);

	UserMessage update(UserMessage bean);

	UserMessage deleteById(Long id);
	
	UserMessage[] deleteByIds(Long[] ids);
	
	UserMessagePage getPage(int pageNo, int pageSize);
	
	
	Page<UserMessage> findPage(Pageable pageable);

	long count(Filter... filters);

	List<UserMessage> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}