package com.ada.user.service;

import com.ada.user.entity.UserMessage;
import com.ada.user.page.UserMessagePage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


public interface UserMessageService {

	public UserMessage findById(Long id);

	public UserMessage save(UserMessage bean);

	public UserMessage update(UserMessage bean);

	public UserMessage deleteById(Long id);
	
	public UserMessage[] deleteByIds(Long[] ids);
	
	public UserMessagePage getPage(int pageNo, int pageSize);
	
	
	public Page<UserMessage> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<UserMessage> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}