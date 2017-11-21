package com.ada.user.service;

import com.ada.user.entity.UserFeedBack;
import com.ada.user.page.UserFeedBackPage;
import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;

public interface UserFeedBackService {

	UserFeedBack findById(Long id);

	UserFeedBack save(UserFeedBack bean);

	UserFeedBack update(UserFeedBack bean);

	UserFeedBack deleteById(Long id);
	
	UserFeedBack[] deleteByIds(Long[] ids);
	
	UserFeedBackPage getPage(int pageNo, int pageSize);
	
	
	Page<UserFeedBack> findPage(Pageable pageable);

	long count(Filter... filters);

	List<UserFeedBack> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}